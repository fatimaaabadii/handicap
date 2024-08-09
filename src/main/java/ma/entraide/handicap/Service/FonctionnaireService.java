package ma.entraide.handicap.Service;

import ma.entraide.handicap.Entity.*;
import ma.entraide.handicap.Repository.FonctionnaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FonctionnaireService {

    @Autowired
    private FonctionnaireRepo fonctionnaireRepo;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private AssociationService associationService;

    @Autowired
    private SpecialiteService specialiteService;


    public List<Fonctionnaire> getAllFonctionnaire() {
        return fonctionnaireRepo.findAll();
    }

    public List<Fonctionnaire> getAllFonctionnaireByProvince(String province) {
        return fonctionnaireRepo.getFoncByProvince(province);
    }

    public Fonctionnaire getFonctionnaireById(Long id) {
        Optional<Fonctionnaire> fonctionnaire = fonctionnaireRepo.findById(id);
        if (fonctionnaire.isPresent()) {
            return fonctionnaire.get();
        }
        else{
            throw new ResourceNotFoundException("Fonctionnaire with id " + id + " not found");
        }
    }

    public Fonctionnaire addFonctionnaire(Fonctionnaire fonctionnaire) {
        Province province = provinceService.getProvinceById(fonctionnaire.getProvince().getId());
        fonctionnaire.setProvince(province);

        Association association = associationService.getAssociationById(fonctionnaire.getAssociation().getId());
        fonctionnaire.setAssociation(association);
        
        Specialite specialite = specialiteService.getSpecialiteById(fonctionnaire.getSpecialite().getId());
        fonctionnaire.setSpecialite(specialite);

      /*  List<Specialite> specialiteOpt = fonctionnaire.getSpecialite();
        List<Specialite> specialites = new ArrayList<Specialite>();
        for(Specialite s : specialiteOpt){
            Specialite specialite = specialiteService.getSpecialiteById(s.getId());
            specialites.add(specialite);
        }*/
       // fonctionnaire.setSpecialite(specialites);

        return fonctionnaireRepo.save(fonctionnaire);
    }

    public Fonctionnaire updateFonctionnaire(Long id , Fonctionnaire fonctionnaire) {
        Fonctionnaire newFonctionnaire = getFonctionnaireById(id);

        Province province = provinceService.getProvinceById(fonctionnaire.getProvince().getId());
        newFonctionnaire.setProvince(province);

        Association association = associationService.getAssociationById(fonctionnaire.getAssociation().getId());
        newFonctionnaire.setAssociation(association);

      /*  List<Specialite> specialiteOpt = fonctionnaire.getSpecialite();
        List<Specialite> specialites = new ArrayList<Specialite>();
        for(Specialite s : specialiteOpt){
            Specialite specialite = specialiteService.getSpecialiteById(s.getId());
            specialites.add(specialite);
        }*/
        newFonctionnaire.setSpecialite(fonctionnaire.getSpecialite());

        newFonctionnaire.setFullName(fonctionnaire.getFullName());
        newFonctionnaire.setSalaireMensuel(fonctionnaire.getSalaireMensuel());
        newFonctionnaire.setContrat(fonctionnaire.getContrat());
        newFonctionnaire.setCnss(fonctionnaire.getCnss());
        newFonctionnaire.setFraisCnss(fonctionnaire.getFraisCnss());
        newFonctionnaire.setMontantAnnuel(fonctionnaire.getMontantAnnuel());

        return fonctionnaireRepo.save(newFonctionnaire);
    }

    public String deleteFonctionnaire(Long id) {
        Fonctionnaire fonctionnaire = getFonctionnaireById(id);
        fonctionnaire.setProvince(null);
        fonctionnaire.setAssociation(null);
        fonctionnaire.setSpecialite(null);

        fonctionnaireRepo.delete(fonctionnaire);
        return "supprimé";
    }

}
