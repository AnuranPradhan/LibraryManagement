package net.Xforce.LibraryManagment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import net.Xforce.LibraryManagment.Entities.Publisher;
import net.Xforce.LibraryManagment.Service.PublisherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;






@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/get-publisher")
    public String getPublishers(Model model){
model.addAttribute("publishers", publisherService.getAllPublishers());
        return "PublisherDirectory/publisher"; 
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable long id,Publisher publisher,Model model) {
       model.addAttribute("publisher", publisherService.getPublisherById(id));
        return "PublisherDirectory/update-Publisher";
    }
@PostMapping("/save-publisher/{id}")
    public String savePublisher(@PathVariable long id, Publisher publisher, Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "PublisherDirectory/update-Publisher";
        }
        publisherService.updatePublisher(publisher);
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "PublisherDirectory/publisher";
    }
@GetMapping("/delete-publisher/{id}")
 public String deletePublisher(@PathVariable long id, Model model) {
        publisherService.deletePublisherById(id);
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "PublisherDirectory/publisher";
    }
@GetMapping("/add-publisher")
 public String addPublisher(Publisher publisher) {
        return "PublisherDirectory/add-publisher";
    }
@PostMapping("/added-publisher")
 public String addedPublisher(Publisher publisher, Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "PublisherDirectory/add-publisher";
        }
        publisherService.createPublisher(publisher);
        model.addAttribute("publishers", publisherService.getAllPublishers());
        return "PublisherDirectory/publisher";
    }
}

