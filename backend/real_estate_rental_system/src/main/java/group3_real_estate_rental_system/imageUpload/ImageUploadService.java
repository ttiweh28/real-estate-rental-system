package group3_real_estate_rental_system.imageUpload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageUploadService {

    private static final String UPLOAD_DIR = "uploads/"; // Folder to store uploaded files

    public List<String> uploadImages(List<MultipartFile> images) {
        List<String> uploadResults = new ArrayList<>();

        // Ensure the upload directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        uploadDir.setReadable(true, false);
        uploadDir.setWritable(true, false);
        uploadDir.setExecutable(true, false);

        // Loop through each image and save it locally
        for (MultipartFile image : images) {
            try {
                // Get original filename
                String originalFilename = StringUtils.cleanPath(image.getOriginalFilename());

                // Generate a new file name (e.g., appending a timestamp to avoid overwriting)
                String fileName = System.currentTimeMillis() + "_" + originalFilename;
                Path filePath = Paths.get(UPLOAD_DIR, fileName);

                // Write file to the disk
                Files.copy(image.getInputStream(), filePath);

                String location = UPLOAD_DIR + fileName;
                // Add the file path or URL to the response
                uploadResults.add(location);

            } catch (IOException e) {
                System.err.println("Error saving " + image.getOriginalFilename() +
                        ": " + e.getMessage());
            }
        }

        return uploadResults; // Return the list of file paths or URLs
    }
}
