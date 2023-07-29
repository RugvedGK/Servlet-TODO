package Dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.annotation.WebServlet;

import lombok.Data;

@Entity
@Data
public class AddTask {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
String name;
String description;
LocalDate start;
LocalDate complete;
boolean status;

}
