package com.logistechs.tranz_sync.service;


import com.logistechs.tranz_sync.entity.Parcel;
import com.logistechs.tranz_sync.repository.ParcelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParcelService {

    private final ParcelRepository parcelRepository;

    public Parcel postParcel(Parcel parcel){
        return parcelRepository.save(parcel);
    }

    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    public Optional<Parcel> getParcelById(Long parcelId) {
        return parcelRepository.findById(parcelId);
    }

    public Parcel updateParcel(Long parcelId, Parcel parcelDetails) {
        return parcelRepository.findById(parcelId)
                .map(existingParcel -> {
                    // Update the properties of existingParcel with the values from parcelDetails
                    // For example:
                    existingParcel.setTracking_code(parcelDetails.getTracking_code());
                    existingParcel.setParcel_type(parcelDetails.getParcel_type());
                    existingParcel.setSender(parcelDetails.getSender());
                    existingParcel.setSender_contact(parcelDetails.getSender_contact());
                    existingParcel.setSender_address(parcelDetails.getSender_address());
                    existingParcel.setReceiver(parcelDetails.getReceiver());
                    existingParcel.setReceiver_contact(parcelDetails.getReceiver_contact());
                    existingParcel.setReceiver_address(parcelDetails.getReceiver_address());
                    existingParcel.setStatus(parcelDetails.getStatus());
                    // ... other property updates ...
                    return parcelRepository.save(existingParcel);
                })
                .orElseThrow(() -> new RuntimeException("Parcel not found with id " + parcelId));
    }

    public void deleteParcel(Long parcelId) {
        parcelRepository.deleteById(parcelId);
    }




}
