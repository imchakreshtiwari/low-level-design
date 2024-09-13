package com.pattern.lowleveldesign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
public class URLDetailsController {

    @Autowired
    private URLShortener urlShortener;

    @PostMapping("/convert/{longURL}")
    public ResponseEntity<String> convertURL(@PathVariable("longURL") String longURL) {

        String shortURL = urlShortener.convertToShortURL(longURL);
        return ResponseEntity.ok(shortURL);
    }

    @GetMapping("/gettt")
    public ResponseEntity<String> getttURL() {

        String longURL = "";
        return ResponseEntity.ok(longURL);
    }

    @GetMapping("/get/{shortURL}")
    public ResponseEntity<String> getURL(@PathVariable("shortURL") String shortURL) {

        String longURL = "";
        return ResponseEntity.ok(longURL);
    }
}
