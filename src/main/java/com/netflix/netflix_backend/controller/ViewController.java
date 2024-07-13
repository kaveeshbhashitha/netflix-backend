package com.netflix.netflix_backend.controller;
import com.netflix.netflix_backend.exception.NotFoundException;
import com.netflix.netflix_backend.model.User;
import com.netflix.netflix_backend.model.Video;
import com.netflix.netflix_backend.model.View;
import com.netflix.netflix_backend.model.ViewDetails;
import com.netflix.netflix_backend.repository.UserRepository;
import com.netflix.netflix_backend.repository.VideoRepository;
import com.netflix.netflix_backend.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/view")
public class ViewController {
    @Autowired
    private ViewRepository viewRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private UserRepository userRepository;

    //Get All View Data
    @GetMapping("/searchAll")
    List<View> getAllViews(){
        return viewRepository.findAll();
    }

    //Add new View to the system
    @PostMapping("/add")
    View newView(@RequestBody View newView){
        return viewRepository.save(newView);
    }

    //Search View by id
    @GetMapping("/searchById/{id}")
    View getViewById(@PathVariable Long id){
        return viewRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    //Search View by video ID
    @GetMapping("/searchByVideoId/{videoId}")
    public List<View> getViewByVideoId(@PathVariable Long videoId){
        return viewRepository.findByVideoId(videoId);
    }

    //search View by user ID
    @GetMapping("/searchByUserId/{userId}")
    public List<View> getViewByUserId(@PathVariable Long userId){
        return viewRepository.findByUserId(userId);
    }

    //delete view
    @DeleteMapping("/delete/{id}")
    String deleteView(@PathVariable Long id) {
        if (!viewRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        viewRepository.deleteById(id);
        return "View with id " + id + " has been deleted successfully.";
    }

    //return all data
    @GetMapping("/searchViewData")
    public List<ViewDetails> getAllViewDetails() {
        List<View> views = viewRepository.findAll();
        return views.stream().map(view -> {
            Video video = videoRepository.findById(view.getVideoId()).orElse(null);
            User user = userRepository.findById(view.getUserId()).orElse(null);
            return new ViewDetails(view, video, user);
        }).collect(Collectors.toList());
    }
}
