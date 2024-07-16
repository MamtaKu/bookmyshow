package com.bookmyshow.bookmyshow;

import com.bookmyshow.bookmyshow.models.*;
import com.bookmyshow.bookmyshow.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {
    private MovieRepository movieRepository;
    private CityRepository cityRepository;
    private TheatreRepository theatreRepository;
    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;
    private final ShowRepository showRepository;

    public BookMyShowApplication(MovieRepository movieRepository, CityRepository cityRepository, TheatreRepository theatreRepository,
                                 SeatRepository seatRepository,
                                 ScreenRepository screenRepository,
                                 ShowRepository showRepository) {
        this.movieRepository = movieRepository;
        this.cityRepository = cityRepository;
        this.theatreRepository = theatreRepository;
        this.seatRepository = seatRepository;
        this.screenRepository = screenRepository;
        this.showRepository = showRepository;
    }

    //    private UserController userController;
//
//    public BookMyShowApplication(UserController userController) {
//        this.userController = userController;
//    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        UserSignUpRequestDTO dto = new UserSignUpRequestDTO();
//        dto.setName("Eva");
//        dto.setEmail("eva@gmail.com");
//        dto.setPassword("eva@123");
//
//        userController.signUp(dto);
//        System.out.println("User has been inserted");
//
//        UserLoginRequestDTO dto1 = new UserLoginRequestDTO();
//        dto1.setEmail("eva@gmail.com");
//        dto1.setPassword("eva@123");
//
//
//        userController.login(dto1);
//        System.out.println("User logged in");

//        Movie movie = new Movie();
//        movie.setName("INDIAN2");
//        movie.setDescription("Indian Tamil-language vigilante action film directed by S. Shankar");
//        movie.setFeatures(Arrays.asList(Feature.values()));
//        movieRepository.save(movie);
//
//
//        Movie movie2 = new Movie();
//        movie2.setName("KALKI");
//        movie2.setDescription("Indian Tamil-language vigilante action film directed by S. Shankar");
//        movie2.setFeatures(Arrays.asList(Feature.HD, Feature.TWO_D));
//        movieRepository.save(movie2);
//
//        Movie movie3 = new Movie();
//        movie3.setName("HANUMAN");
//        movie3.setDescription("Indian Tamil-language vigilante action film directed by S. Shankar");
//        movie3.setFeatures(Arrays.asList(Feature.HD, Feature.TWO_D));
//        movieRepository.save(movie3);
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
//
//
//        City city1 = new City();
//        city1.setName("Bangalore");
//        //city1.setTheatres(Arrays.asList(theatre1,theatre6, theatre2));
//        cityRepository.save(city1);
//
//        City city2 = new City();
//        city2.setName("Mumbai");
//        //city2.setTheatres(Arrays.asList(theatre3,theatre4,theatre5));
//        cityRepository.save(city2);
//
//        City city3 = new City();
//        city3.setName("Kolkata");
//        //city3.setTheatres(Arrays.asList(theatre1,theatre4));
//        cityRepository.save(city3);
//
//        Theatre theatre1 = new Theatre();
//        theatre1.setName("Nexus");
//      //  theatre1.setScreens(Arrays.asList(screen));
//        theatre1.setCity(city1);
//        theatreRepository.save(theatre1);
//
//        Theatre theatre2 = new Theatre();
//        theatre2.setName("Orion");
//     //   theatre2.setScreens(Arrays.asList(screen,screen2));
//        theatre2.setCity(city2);
//        theatreRepository.save(theatre2);
//
//        Theatre theatre3 = new Theatre();
//        theatre3.setName("lulu mall");
//     //   theatre3.setScreens(Arrays.asList(screen, screen2, screen3));
//        theatre3.setCity(city3);
//        theatreRepository.save(theatre3);
//
//
//        Theatre theatre4 = new Theatre();
//        theatre4.setName("Shantiniketan");
//     //   theatre4.setScreens(Arrays.asList(screen,screen2,screen3));
//        theatre4.setCity(city1);
//
//        theatreRepository.save(theatre4);
//
//
//        Theatre theatre5 = new Theatre();
//        theatre5.setName("Miraj");
//     //   theatre5.setScreens(Arrays.asList(screen));
//        theatre5.setCity(city2);
//
//        theatreRepository.save(theatre5);
//
//        Theatre theatre6 = new Theatre();
//        theatre6.setName("Forum");
//     //   theatre6.setScreens(Arrays.asList(screen,screen3));
//        theatre6.setCity(city3);
//
//        theatreRepository.save(theatre6);
//
//        Screen screen = new Screen();
//        screen.setName("Audi 1");
//        //screen.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen.setTheatre(theatre1);
//        screenRepository.save(screen);
////
//        Screen screen2 = new Screen();
//        screen2.setName("Audi 2");
//       // screen2.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen2.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen2.setTheatre(theatre2);
//        screenRepository.save(screen2);
//
//        Screen screen3 = new Screen();
//        screen3.setName("Audi 3");
//       // screen3.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen3.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen3.setTheatre(theatre3);
//        screenRepository.save(screen3);
//
//        Seat seat = new Seat();
//        seat.setRowval(1);
//        seat.setColval(1);
//        seat.setSeatNumber("A1");
//        seat.setSeatType(SeatType.SILVER);
//        seat.setScreen(screen);
//        seatRepository.save(seat);
//
//        Seat seat2 = new Seat();
//        seat2.setRowval(2);
//        seat2.setColval(1);
//        seat2.setSeatNumber("B1");
//        seat2.setSeatType(SeatType.GOLD);
//        seat2.setScreen(screen2);
//        seatRepository.save(seat2);
//
//        Seat seat3 = new Seat();
//        seat3.setRowval(3);
//        seat3.setColval(1);
//        seat3.setSeatNumber("C1");
//        seat3.setSeatType(SeatType.RECLINER);
//        seat3.setScreen(screen3);
//        seatRepository.save(seat3);
//
//        Show show = new Show();
//        show.setMovie(movie);
//        show.setStartTime(new Date());
//        show.setEndTime(new Date());
//        show.setMovie(movie2);
//        show.setScreen(screen);
//        show.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show);
//
//        Show show2 = new Show();
//        show2.setMovie(movie);
//        show2.setStartTime(new Date());
//        show2.setEndTime(new Date());
//        show2.setMovie(movie3);
//        show2.setScreen(screen2);
//        show2.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show2);
//
//
//
//
//










    }
}
