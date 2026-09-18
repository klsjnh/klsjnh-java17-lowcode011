package com.klsjnh.lowcode011.application.intake;

/*                CopySourceAdapter class
 *
 *      @author     xiangrkrs@163.com
 *      @version    ver 0.0.1
 *      @createdate 2026.09.18
 *      @modifydate
 *
 *===========================================
 *          modify history
 *
 *      2026.09.18  copy source adapter class
 *
 */

import com.klsjnh.common.exception.BusinessException;

import com.klsjnh.lowcode011.domain.ModelSourceKind011;
import com.klsjnh.lowcode011.domain.ModelSourcePort;
import com.klsjnh.lowcode011.domain.SourceRequest;
import com.klsjnh.lowcode011.domain.records.MetadataContent;
import com.klsjnh.lowcode011.domain.records.MetadataContentCodec;
import com.klsjnh.lowcode011.application.designer.JulyMetadataDesignerUseCase;

import org.springframework.stereotype.Component;

/**
 * Copy source: read an existing object as content (optionally renamed). Reuses
 * the designer load (aggregate → MetaDTO).
 */

@Component
public class CopySourceAdapter implements ModelSourcePort {

    /**
     * Designer use case (object load).
     */
    private final JulyMetadataDesignerUseCase designerUseCase;

    /**
     * Create the adapter.
     *
     * @param designerUseCase designer use case
     */
    public CopySourceAdapter(JulyMetadataDesignerUseCase designerUseCase) {
        this.designerUseCase = designerUseCase;
    }

    /** {@inheritDoc} */
    @Override
    public String kind() {
        return ModelSourceKind011.COPY;
    }

    /** {@inheritDoc} */
    @Override
    public MetadataContent intake(SourceRequest request) {
        String ref = request.ref() == null || request.ref().isBlank() ? request.objectName() : request.ref();

        if (ref == null || ref.isBlank()) {
            throw BusinessException.badRequest("ref or objectName required for copy source");
        }

        return rename(MetadataContentCodec.fromMetaDto(designerUseCase.load(ref)), request.objectName());
    }
}
