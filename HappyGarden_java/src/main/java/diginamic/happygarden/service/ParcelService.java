package diginamic.happygarden.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import diginamic.happygarden.model.Parcel;
import diginamic.happygarden.repository.ParcelRepository;

@Transactional
@Service
public class ParcelService extends AbstractService<Parcel, Long, ParcelRepository> {

}