package ccbill.training.sfgpetclinic.services.springdatajpa;

import ccbill.training.sfgpetclinic.model.Speciality;
import ccbill.training.sfgpetclinic.repositories.SpecialityRepository;
import ccbill.training.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springDataJPA")
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        Optional<Speciality> optionalSpeciality = specialityRepository.findById(id);
        return optionalSpeciality.orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
