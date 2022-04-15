package insee.stage.demo.service;


import insee.stage.demo.model.Paradata;
import insee.stage.demo.repository.MetadataRepository;
import insee.stage.demo.repository.ParadataRepository;

public class ParadataService {

    private final ParadataRepository paradataRepository;

    public ParadataService(ParadataRepository paradataRepository){
        this.paradataRepository = paradataRepository;
    }

    public void addParadata(Paradata paradata) {
        paradataRepository.insert(paradata);
    }
}
