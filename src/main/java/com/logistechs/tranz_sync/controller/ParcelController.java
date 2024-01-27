package com.logistechs.tranz_sync.controller;

import com.logistechs.tranz_sync.entity.Parcel;
import com.logistechs.tranz_sync.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600) // Or use "*" for all origins
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ParcelController {

    private final ParcelService parcelService;


    @PostMapping("/parcel")
    public Parcel postParcel(@RequestBody Parcel parcel){
        return parcelService.postParcel(parcel);
    }

    @GetMapping("/parcel")
    public List<Parcel> getAllParcels() {
        return parcelService.getAllParcels();
    }

    @GetMapping("/parcel/{id}")
    public ResponseEntity<Parcel> getParcelById(@PathVariable Long id) {
        return parcelService.getParcelById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/parcel/{id}")
    public ResponseEntity<Parcel> updateParcel(@PathVariable Long id, @RequestBody Parcel parcelDetails) {
        return ResponseEntity.ok(parcelService.updateParcel(id, parcelDetails));
    }

    @DeleteMapping("/parcel/{id}")
    public ResponseEntity<?> deleteParcel(@PathVariable Long id) {
        parcelService.deleteParcel(id);
        return ResponseEntity.ok().build();
    }











}
