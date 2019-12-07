package de.s3fagawa.deeperwebshit.pictures;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface zu der inmemory DB.
 * Stellt Zugriffsfkt bereit.
 */

public interface PictureRepository extends CrudRepository<Picture, Long> {

}
