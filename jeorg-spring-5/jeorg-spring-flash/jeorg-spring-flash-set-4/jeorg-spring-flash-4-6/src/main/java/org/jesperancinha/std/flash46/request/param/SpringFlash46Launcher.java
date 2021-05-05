package org.jesperancinha.std.flash46.request.param;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.html.HtmlizerLinks.getYouTubeFrame;
import static org.jesperancinha.std.flash46.request.param.CatType.BENGAL;
import static org.jesperancinha.std.flash46.request.param.CatType.MAINE_COON;
import static org.jesperancinha.std.flash46.request.param.CatType.PERSIAN;
import static org.jesperancinha.std.flash46.request.param.CatType.SAVANNAH;
import static org.jesperancinha.std.flash46.request.param.CatType.SCOTTISH_FOLD;
import static org.jesperancinha.std.flash46.request.param.CatType.SIAMESE;
import static org.jesperancinha.std.flash46.request.param.DogType.BELGIAN_SHEPPARD;
import static org.jesperancinha.std.flash46.request.param.DogType.COCKERS_SPANIEL;
import static org.jesperancinha.std.flash46.request.param.DogType.DOBERMANN;
import static org.jesperancinha.std.flash46.request.param.DogType.GERMAN_SHEPPARD;
import static org.jesperancinha.std.flash46.request.param.DogType.ROTTWEILLER;
import static org.jesperancinha.std.flash46.request.param.DogType.SIBERIAN_HUSKY;

@RestController
@SpringBootApplication
public class SpringFlash46Launcher {
    public static void main(String[] args) {
        SpringApplication.run(new Class[]{SpringFlash46Launcher.class}, args);
    }


    public SpringFlash46Launcher() {
    }

    @GetMapping("/")
    public void index(HttpServletResponse httpServletResponse) throws IOException {
        final PrintWriter writer = httpServletResponse.getWriter();
        writer.write(BLUE.getPBEscapedText("Cats"));
        writer.write(GREEN.getAnchorLink(BENGAL, "http://localhost:8081/cats?catType=BENGAL"));
        writer.write(GREEN.getAnchorLink(PERSIAN, "http://localhost:8081/cats?catType=PERSIAN"));
        writer.write(GREEN.getAnchorLink(MAINE_COON, "http://localhost:8081/cats?catType=MAINE_COON"));
        writer.write(GREEN.getAnchorLink(SAVANNAH, "http://localhost:8081/cats?catType=SAVANNAH"));
        writer.write(GREEN.getAnchorLink(SCOTTISH_FOLD, "http://localhost:8081/cats?catType=SCOTTISH_FOLD"));
        writer.write(GREEN.getAnchorLink(SIAMESE, "http://localhost:8081/cats?catType=SIAMESE"));
        writer.write(BLUE.getPBEscapedText("Dogs"));
        writer.write(GREEN.getAnchorLink(DOBERMANN, "http://localhost:8081/dogs?dogType=DOBERMANN"));
        writer.write(GREEN.getAnchorLink(SIBERIAN_HUSKY, "http://localhost:8081/dogs?dogType=SIBERIAN_HUSKY"));
        writer.write(GREEN.getAnchorLink(ROTTWEILLER, "http://localhost:8081/dogs?dogType=ROTTWEILLER"));
        writer.write(GREEN.getAnchorLink(COCKERS_SPANIEL, "http://localhost:8081/dogs?dogType=COCKERS_SPANIEL"));
        writer.write(GREEN.getAnchorLink(GERMAN_SHEPPARD, "http://localhost:8081/dogs?dogType=GERMAN_SHEPPARD"));
        writer.write(GREEN.getAnchorLink(BELGIAN_SHEPPARD, "http://localhost:8081/dogs?dogType=BELGIAN_SHEPPARD"));

    }

    @GetMapping("/cats")
    public void showCat(
            @RequestParam
                    CatType catType, HttpServletResponse httpServletResponse) throws IOException {
        final var writer = httpServletResponse.getWriter();
        switch (catType) {
            case BENGAL:
                writer.write(getYouTubeFrame("FVGhzxzx88M"));
                break;
            case PERSIAN:
                writer.write(getYouTubeFrame("RYe0pHIMsaU"));
                break;
            case MAINE_COON:
                writer.write(getYouTubeFrame("weebcQPRGUE"));
                break;
            case SAVANNAH:
                writer.write(getYouTubeFrame("abuAUjFv88s"));
                break;
            case SCOTTISH_FOLD:
                writer.write(getYouTubeFrame("lnlg55QR3hw"));
                break;
            case SIAMESE:
                writer.write(getYouTubeFrame("Q4Vjadpyehw"));
                break;
            default:

        }
    }

    @GetMapping("/dogs")
    public void showDog(
            @RequestParam
                    DogType dogType, HttpServletResponse httpServletResponse) throws IOException {
        final var writer = httpServletResponse.getWriter();
        switch (dogType) {
            case DOBERMANN:
                writer.write(getYouTubeFrame("0LgCGpbMhAo"));
                break;
            case SIBERIAN_HUSKY:
                writer.write(getYouTubeFrame("tbn8IF0D9Yg"));
                break;
            case ROTTWEILLER:
                writer.write(getYouTubeFrame("GBZnnOe_n5g"));
                break;
            case COCKERS_SPANIEL:
                writer.write(getYouTubeFrame("k4N_DkpMZAY"));
                break;
            case GERMAN_SHEPPARD:
                writer.write(getYouTubeFrame("MxaJb-fYR4M"));
                break;
            case BELGIAN_SHEPPARD:
                writer.write(getYouTubeFrame("VcsyScrd0UQ"));
            default:
        }
    }
}
