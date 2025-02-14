package org.example.ecomproj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;


@Component // Spring will create an object of this class
@Entity // This will be a table in our db
@Data // Automatically creates getters and setters
@AllArgsConstructor // Creates a constructor
@NoArgsConstructor // Creates a constructor
public class Product {

    @Id // specify the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Ids are automatically generated
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // Setup date format using json
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;

    private String imageName;
    private String imageType;
    @Lob // When storing large objects (like a byte array) with need @Lob (large object)
    private byte[] imageData;
}
