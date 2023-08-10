package com.backend.coffeeshop.Controller;
import com.backend.coffeeshop.Model.Images;
import com.backend.coffeeshop.Model.Menu;
import com.backend.coffeeshop.Model.Shop;
import com.backend.coffeeshop.Model.Users;
import com.backend.coffeeshop.Repository.ImageRepository;
import com.backend.coffeeshop.Repository.MenuRepository;
import com.backend.coffeeshop.Repository.ShopRepository;
import com.backend.coffeeshop.Repository.UsersRepository;
import com.backend.coffeeshop.Service.FileServices;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {
@Autowired
private ImageRepository imageRepository;
@Autowired
private FileServices fileServices;

@Value("${project.image}")
private String path;

@Autowired
private UsersRepository usersRepository;

@Autowired
private MenuRepository menuRepository;

@Autowired
private ShopRepository shopRepository;

@GetMapping("/hello")
public String hello(){
  return "hello";
}
  @CrossOrigin(origins = "http://localhost:3000/")
  @PostMapping("/uploadImage")
    public ResponseEntity<Object> uploadPicture(@RequestParam("file") MultipartFile image) throws IOException {
      String fileName= StringUtils.cleanPath(image.getOriginalFilename());
      String uploadDir="./images";
      File directory=new File(uploadDir);
      if(!directory.exists()){
          directory.mkdirs();
      }

      //save the file to specified directory
      Path filepath= Path.of(uploadDir,fileName);
      Files.copy(image.getInputStream(),filepath, StandardCopyOption.REPLACE_EXISTING);
      Images savedFile=new Images();
      savedFile.setImage_path(fileName);
     Images data=imageRepository.save(savedFile);
     return ResponseEntity.ok(data);

  }

    @CrossOrigin(origins = "http://localhost:3000/")
  @GetMapping(value = "images/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
  public void getImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {
     InputStream resource=this.fileServices.getResource(path,imageName);
     response.setContentType(MediaType.IMAGE_JPEG_VALUE);
     if(imageName.endsWith(".jpg") || imageName.endsWith(".jpeg")){
       response.setContentType(MediaType.IMAGE_JPEG_VALUE);
     }else if(imageName.endsWith(".png")){
       response.setContentType(MediaType.IMAGE_PNG_VALUE);
     }else if(imageName.endsWith(".gif")){
       response.setContentType(MediaType.IMAGE_GIF_VALUE);

     }
    StreamUtils.copy(resource,response.getOutputStream());

  }
 @CrossOrigin("http://localhost:3000/")
  @PostMapping("/add_coffee")
    public ResponseEntity<Object> addCoffee(@RequestParam("coffeeName") String coffeeName,@RequestParam("coffeeDescription") String coffeeDescription,@RequestParam("coffeeImage") String coffeeImage){
    Menu menuData=new Menu();
    menuData.setCoffee_name(coffeeName);
    menuData.setCoffee_description(coffeeDescription);
    menuData.setCoffee_image(coffeeImage);
    Menu savedData=menuRepository.save(menuData);
    return    ResponseEntity.ok(savedData);
  }
 @CrossOrigin("http://localhost:3000/")
  @PostMapping("/add_shop")
  public ResponseEntity<Object> addShop(@RequestParam("shopName") String shopName, @RequestParam("shopAddress")String shopAddress, @RequestParam("shopOpeningDate") String shopOpeningDate,@RequestParam("shopImage") String shopImage){
        Shop shopData=new Shop();
        shopData.setShop_name(shopName);
        shopData.setShop_address(shopAddress);
        shopData.setShop_picture(shopImage);
        shopData.setShop_opening_date(shopOpeningDate);

        Shop savedData=shopRepository.save(shopData);
      return ResponseEntity.ok(savedData);
  }
    @CrossOrigin(origins = "http://localhost:3000/")
  @GetMapping("/getmenu")
  public ResponseEntity<Object> getMenu(){
    Iterable<Menu> data= menuRepository.findAll();
    return  ResponseEntity.ok(data);
  }

    @CrossOrigin(origins = "http://localhost:3000/")
  @PostMapping("/signup")
  public ResponseEntity<Object> signUp(@RequestParam("user_name") String userName,@RequestParam("user_email")String userEmail,@RequestParam("user_contact") String userContact,@RequestParam("user_age") String  userAge,@RequestParam("user_gender") String userGender,@RequestParam("user_password")String userPassword){
     Users userData=new Users();
     userData.setUser_name(userName);
     userData.setUser_email(userEmail);
     userData.setUser_contact(userContact);
     userData.setUser_gender(userGender);
     userData.setUser_age(userAge);
     userData.setUser_password(userPassword);
     userData.setUser_type("Admin");
      Calendar calandar=Calendar.getInstance();
     userData.setUser_registration_date(calandar.getTime());
     Users data=usersRepository.save(userData);
     return ResponseEntity.ok(data);
  }



}
