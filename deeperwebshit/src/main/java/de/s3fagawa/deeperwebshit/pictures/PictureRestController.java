package de.s3fagawa.deeperwebshit.pictures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;

/**
 * REST-Controller verarbeitet REST-Zugriffe.
 */
@CrossOrigin
@RestController                         //erzeugt Controller, stellt REST Funktionen bereit.
@RequestMapping("picture")              //Pfad zur Bilder Funktionalität
public class PictureRestController {
    @Autowired                          //Verbindung Interface unserer DB mit Controller
    public PictureRepository picRepo;   //Anlegen der Inmemory DB
    @PostMapping("")                    //Methodendefinition als POST mit Pfad
    public ResponseEntity<?> createPicture(@RequestBody MultipartFile pictureDate) throws IOException { //REST-Service kann hier bild hochladen
        Picture pic = new Picture();                                //Erstellen einer neuen Bild-datei
        pic.setPictureArray(pictureDate.getBytes());                //hochzulandendes Bild in Bytearray von Picture Objekt konvertieren
        picRepo.save(pic);                                          //speichern des Objekt in DB
        return ResponseEntity.status(HttpStatus.CREATED).body(pic); //retournieren des Statuscode und der Infos vom Picture-Objekt
    }
    @GetMapping("formatted/{picId}")    //Methodendefinition als GET mit Pfad
    public ResponseEntity<?> getPicture(@PathVariable Long picId) {                                     //Bild soll anhand von Id zurückgeliefert werden
        Optional<Picture> pic = picRepo.findById(picId);                                                //Laden von Bild aus Db in Variable
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pic.get().getPictureArray()); //Rückgabe von Status und Variable interpretiert als Bild
    }

    @GetMapping("{picId}")              //Methodendefinition als Get mit Pfad
    public ResponseEntity<?> getPictureAsJson(@PathVariable Long picId) {   //Rückgabe als JSON, also ohne Bild
        Optional<Picture> pic = picRepo.findById(picId);                    //Laden des Bildobjektes in Variable
        return ResponseEntity.ok(pic.get());                                //Rückgabe des Status und Variablen ohne Bild
    }
}
