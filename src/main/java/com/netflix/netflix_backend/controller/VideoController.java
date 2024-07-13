package com.netflix.netflix_backend.controller;
import com.netflix.netflix_backend.exception.NotFoundException;
import com.netflix.netflix_backend.model.Video;
import com.netflix.netflix_backend.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoRepository videoRepository;

    //Get All Video Data
    @GetMapping("/searchAll")
    List<Video> getAllVideo(){
        return videoRepository.findAll();
    }

    //Add new video to the system
    @PostMapping("/add")
    Video newVideo(@RequestBody Video newVideo){
        return videoRepository.save(newVideo);
    }

    //Search video by id
    @GetMapping("/searchById/{id}")
    Video getVideoById(@PathVariable Long id){
        return videoRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    //Search video by video title
    @GetMapping("/searchByTitle/{videoTitle}")
    Video getVideoByTitle(@PathVariable String videoTitle){
        return videoRepository.findByVideoTitle(videoTitle);
    }

    //search by category
    @GetMapping("/searchByCategory/{category}")
    public List<Video> getVideosByCategory(@PathVariable String category) {
        return videoRepository.findByCategory(category);
    }

    //search by video type
    @GetMapping("/searchByVideoType/{videoType}")
    Video getVideoByVideoType(@PathVariable String videoType){
        return videoRepository.findByVideoType(videoType);
    }

    //Update video data
    @PutMapping("/update/{id}")
    Video updatePatients(@RequestBody Video updateVideo, @PathVariable Long id){
        return videoRepository.findById(id).map(video -> {
            video.setVideoTitle(updateVideo.getVideoTitle());
            video.setYoutubeId(updateVideo.getYoutubeId());
            video.setCategory(updateVideo.getCategory());
            video.setVideoType(updateVideo.getVideoType());
            return videoRepository.save(video);
        }).orElseThrow(()->new NotFoundException(id));
    }

    //delete video
    @DeleteMapping("/delete/{id}")
    String deleteVideo(@PathVariable Long id) {
        if (!videoRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        videoRepository.deleteById(id);
        return "Video with id " + id + " has been deleted successfully.";
    }
}
