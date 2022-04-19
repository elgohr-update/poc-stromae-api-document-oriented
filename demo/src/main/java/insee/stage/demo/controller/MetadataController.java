package insee.stage.demo.controller;

import insee.stage.demo.model.Metadata;
import insee.stage.demo.service.MetadataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class MetadataController {
    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService){
        this.metadataService = metadataService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metadata> getMetadataById(@PathVariable String id) {
        return ResponseEntity.ok(metadataService.getMetadataById(id));
    }
}
