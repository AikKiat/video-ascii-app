ALTER TABLE customer
ADD COLUMN profile_image_id VARCHAR(36); /*Since we generate the profile image id via UUID.randomID(), 36 is the length of a UUID*/

ALTER TABLE customer
ADD CONSTRAINT profile_image_id_unique
UNIQUE(profile_image_id);