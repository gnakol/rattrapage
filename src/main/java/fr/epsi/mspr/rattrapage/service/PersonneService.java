package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.Personne;
import fr.epsi.mspr.rattrapage.interfacee.PersonneInterface;
import fr.epsi.mspr.rattrapage.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PersonneService implements PersonneInterface {

    @Autowired
    private final PersonneRepository personneRepository;

    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public List<Personne> showUser() {
        return personneRepository.findAll();
    }

    @Override
    public void addUser(Personne personne) {
        personneRepository.save(personne);
    }

    @Override
    public Personne updateUser(int id_user, Personne user) {
        return personneRepository.findById(id_user)
                .map(p->{
                    p.setUser_name(user.getUser_name());
                    p.setPassword(user.getPassword());
                    p.setE_mail(user.getE_mail());
                    return personneRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("user do not exist"));
    }

    @Override
    public void removeUser(int id_user) {
        Personne user = personneRepository.findById(id_user).get();

        if(user != null)
            personneRepository.delete(user);
    }

    @Override
    public Personne searchByIdUser(int id_user) {
        return personneRepository.findById(id_user).orElseThrow(()-> new RuntimeException("desoler non trouver cette personne"));
    }

    public String scriptPassword(String password) throws GeneralSecurityException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] data = md.digest();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < data.length; i++)
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        return sb.toString();
    }


}
