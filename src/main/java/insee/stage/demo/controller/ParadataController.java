package insee.stage.demo.controller;

import insee.stage.demo.model.Paradata;
import insee.stage.demo.service.MetadataService;
import insee.stage.demo.service.ParadataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/paradata")
public class ParadataController {


    private final ParadataService paradataService;

    public ParadataController(ParadataService paradataService){
        this.paradataService = paradataService;
    }
    /** POST paradata **/

    @PostMapping
    public ResponseEntity addParadataById(@RequestBody Paradata paradata, @RequestBody String Id) {
        paradataService.addParadata(paradata);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
