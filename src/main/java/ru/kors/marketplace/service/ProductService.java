package ru.kors.marketplace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.kors.marketplace.models.Image;
import ru.kors.marketplace.models.Product;
import ru.kors.marketplace.models.User;
import ru.kors.marketplace.repositories.ProductRepository;
import ru.kors.marketplace.repositories.UserRepository;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private List<Product> products = new ArrayList<>();
    private static Long ID = 0L;

    public List<Product> getProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Principal principal, Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5) throws IOException {
        product.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        Image image4;
        Image image5;

        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }
        if (file4.getSize() != 0) {
            image4 = toImageEntity(file4);
            product.addImageToProduct(image4);
        }
        if (file5.getSize() != 0) {
            image5 = toImageEntity(file5);
            product.addImageToProduct(image5);
        }

        log.info("Saving new Product. Title: {}; Author email: {}", product.getTitle(), product.getUser().getEmail());

        Product productFromDB = productRepository.save(product);
        productFromDB.setPreviewImageId(productFromDB.getImages().get(0).getId());

        productRepository.save(product);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setSize(file.getSize());
        image.setContentType(file.getContentType());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductByID(Long id) {
        return productRepository.findById(id).orElse(null);
    }

//    {
//        products.add(new Product(++ID, "Лунцзин Фуян Сань Ча", "\n" +
//                "Сделан из первых весенних почек урожая 2023 года в Фуяне (провинция Чжэцзян).\n" +
//                "\n" +
//                "В сухом виде: крупные, фисташково-зеленые, плоские почки. Аромат интенсивный, пряно-ореховый. Настой прозрачный, светлого золотисто-зеленого оттенка.\n" +
//                "\n" +
//                "Букет готового чая свежий, травянисто-ореховый с нотками жареных семечек подсолнуха и луговых цветов. Аромат интенсивный, пряно-ореховый. Вкус плотный и гладкий, маслянистый, отчетливо сладкий, с тонкой кислинкой зеленых яблок, терпчинкой виноградной кожицы и долгим, сочным послевкусием. \n" +
//                "\n" +
//                "Заваривать горячей водой (80-85°С) в чайнике из пористой глины или фарфоровой гайвани. Пропорция заварки к воде: 5 г на 100 мл. Первый раз настоять 20 секунд, после чего, начиная с экспозиции в 10 секунд и доведя время заваривания до 2 минут, можно заварить еще 5 раз.\n" +
//                "\n" +
//                "Отличный зеленый чай, наполненный дыханием жизни, весной и оптимизмом.", "Жареные семечки подсолнуха, " +
//                "Цветочный, " +
//                "Травянистый, " +
//                "Ореховый", 8300, 100, "Entity"));
//        products.add(new Product(++ID, "Удан Улун Хун Ча", "Сделан весной 2023 из побегов сорта Улун по технологии красного чая.\n" +
//                "\n" +
//                "В сухом виде: маленькие, тонкие жгутики темно-коричневых чайных почек. Аромат интенсивный, фруктовый. Настой прозрачный, янтарного оттенка.\n" +
//                "\n" +
//                "Букет готового чая теплый, фруктово-цветочный, с древесными и бисквитными нотками. Аромат густой и теплый, фруктово-цветочный. Вкус мягкий, шелковистый, сладковатый, с легкой фруктовой кислинкой и освежающим послевкусием. \n" +
//                "\n" +
//                "Заваривать горячей водой (95°С) в чайнике из пористой глины. Пропорция заварки к воде: 5-6 г на 100 мл. Для первого раза настоять 15 секунд, далее, начиная с экспозиции в 5-7 секунд и доведя время до 2 минут, можно заварить еще 5 раз.", "Цветочный,\n" +
//                "Сухофрукты,\n" +
//                "Древесный,\n" +
//                "Бисквитный", 970, 100, "Torky"));
//    }
}
