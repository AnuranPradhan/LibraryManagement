package net.Xforce.LibraryManagment.Service;

import net.Xforce.LibraryManagment.Entities.Publisher;

import net.Xforce.LibraryManagment.Repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;


    public List<Publisher> getAllPublishers() {

        return publisherRepository.findAll();
    }
    public Publisher getPublisherById(long id){
        return publisherRepository.findById(id).orElseThrow(()->new RuntimeException("Publisher By This Id Not Found"));
    }
    public Publisher createPublisher(Publisher Publisher) {
        return publisherRepository.save(Publisher);
    }

    public void deletePublisherById(long PublisherId) {
        publisherRepository.deleteById(PublisherId);
    }

    public Publisher updatePublisher(Publisher Publisher){
        return publisherRepository.save(Publisher);
    }
}
