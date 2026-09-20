package com.klsjnh.lowcode011.application.intake;

/*                ModelingSourceAdapter class
 *
 *      @author     xiangrkrs@163.com
 *      @version    ver 0.0.1
 *      @createdate 2026.09.18
 *      @modifydate
 *
 *===========================================
 *          modify history
 *
 *      2026.09.18  modeling hand-off source adapter class
 *
 */

import com.klsjnh.common.exception.BusinessException;

import com.klsjnh.lowcode011.application.modeling.JulyBusinessModelingUseCase;
import com.klsjnh.lowcode011.domain.modeling.JulyBusinessModeling;
import com.klsjnh.lowcode011.domain.intake.ModelSourceKind011;
import com.klsjnh.lowcode011.domain.intake.ModelSourcePort;
import com.klsjnh.lowcode011.domain.intake.SourceRequest;
import com.klsjnh.lowcode011.domain.metadata.MetadataContent;

import org.springframework.stereotype.Component;

/**
 * Modeling hand-off source: read a 033 business-modeling record's content
 * (optionally renamed). This is the two-domain hand-off made concrete.
 */

@Component
public class ModelingSourceAdapter implements ModelSourcePort {

    /**
     * Business modeling use case (hand-off read).
     */
    private final JulyBusinessModelingUseCase modelingUseCase;

    /**
     * Create the adapter.
     *
     * @param modelingUseCase business modeling use case
     */
    public ModelingSourceAdapter(JulyBusinessModelingUseCase modelingUseCase) {
        this.modelingUseCase = modelingUseCase;
    }

    /** {@inheritDoc} */
    @Override
    public String kind() {
        return ModelSourceKind011.MODELING;
    }

    /** {@inheritDoc} */
    @Override
    public MetadataContent intake(SourceRequest request) {
        if (request.ref() == null || request.ref().isBlank()) {
            throw BusinessException.badRequest("ref (modelCode) required for modeling source");
        }

        JulyBusinessModeling model = modelingUseCase.getByCode(request.ref());

        if (model == null) {
            throw BusinessException.badRequest("modeling record not found: " + request.ref());
        }

        return rename(model.content(), request.objectName());
    }
}
