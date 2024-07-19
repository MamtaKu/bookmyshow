package com.bookmyshow.bookmyshow;

import com.bookmyshow.bookmyshow.models.*;
import com.bookmyshow.bookmyshow.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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
//        movie.setFeatures(Arrays.asList(Feature.TWO_D));
//        movieRepository.save(movie);
//
//
//        Movie movie2 = new Movie();
//        movie2.setName("KALKI");
//        movie2.setDescription("Indian Tamil-language vigilante action film directed by S. Shankar");
//        movie2.setFeatures(Arrays.asList(Feature.HD));
//        movieRepository.save(movie2);
//
//        Movie movie3 = new Movie();
//        movie3.setName("HANUMAN");
//        movie3.setDescription("Indian Tamil-language vigilante action film directed by S. Shankar");
//        movie3.setFeatures(Arrays.asList(Feature.IMAX));
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
//
//
//        Theatre theatre1 = new Theatre();
//        theatre1.setName("Phoenix Marketcity");
//        //theatre1.setScreens(Arrays.asList(screen,screen2,screen3));
//        theatre1.setCity(city1);
//        theatreRepository.save(theatre1);
//
//        Theatre theatre2 = new Theatre();
//        theatre2.setName("Orion Mall");
//        //theatre2.setScreens(Arrays.asList(screen,screen2,screen3));
//        theatre2.setCity(city1);
//        theatreRepository.save(theatre2);
//
//        Theatre theatre3 = new Theatre();
//        theatre3.setName("Forum Mall");
//        //theatre3.setScreens(Arrays.asList(screen, screen2, screen3));
//        theatre3.setCity(city1);
//        theatreRepository.save(theatre3);
//
//
//        Theatre theatre4 = new Theatre();
//        theatre4.setName("High Street Phoenix");
//       // theatre4.setScreens(Arrays.asList(screen,screen2,screen3));
//        theatre4.setCity(city2);
//
//        theatreRepository.save(theatre4);
//
//
//        Theatre theatre5 = new Theatre();
//        theatre5.setName("Inorbit Mall");
//       // theatre5.setScreens(Arrays.asList(screen,screen2,screen3));
//        theatre5.setCity(city2);
//
//        theatreRepository.save(theatre5);
//
//        Theatre theatre6 = new Theatre();
//        theatre6.setName("Oberoi Mall");
//       // theatre6.setScreens(Arrays.asList(screen,screen2,screen3));
//        theatre6.setCity(city2);
//
//        theatreRepository.save(theatre6);
//
//        Theatre theatre7 = new Theatre();
//        theatre7.setName("South City Mall");
//       // theatre7.setScreens(Arrays.asList(screen,screen2,screen3));
//        theatre7.setCity(city3);
//
//        theatreRepository.save(theatre7);
//
//
//        Theatre theatre8 = new Theatre();
//        theatre8.setName("City Centre Salt Lake");
//       // theatre8.setScreens(Arrays.asList(screen,screen2,screen3));
//        theatre8.setCity(city3);
//
//        theatreRepository.save(theatre8);
//
//        Theatre theatre9 = new Theatre();
//        theatre9.setName("Quest Mall");
//       // theatre9.setScreens(Arrays.asList(screen,screen2,screen3));
//        theatre9.setCity(city3);
//
//        theatreRepository.save(theatre9);
//
//        Screen screen = new Screen();
//        screen.setName("PVR Screen 1");
//        //screen.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen.setTheatre(theatre1);
//        screenRepository.save(screen);
////
//        Screen screen2 = new Screen();
//        screen2.setName("PVR Screen 2");
//        // screen2.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen2.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//         screen2.setTheatre(theatre1);
//        screenRepository.save(screen2);
//
//        Screen screen3 = new Screen();
//        screen3.setName("PVR Screen 3");
//        // screen3.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen3.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen3.setTheatre(theatre1);
//        screenRepository.save(screen3);
//
//        Screen screen4 = new Screen();
//        screen4.setName("Aud1 1");
//        //screen.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen4.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen4.setTheatre(theatre2);
//        screenRepository.save(screen4);
////
//        Screen screen5 = new Screen();
//        screen5.setName("Audi 2");
//        // screen2.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen5.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen5.setTheatre(theatre2);
//        screenRepository.save(screen5);
//
//        Screen screen6 = new Screen();
//        screen6.setName("Audi 3");
//        // screen3.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen6.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen6.setTheatre(theatre2);
//        screenRepository.save(screen6);
//
//        Screen screen7 = new Screen();
//        screen7.setName("PVR Screen 7");
//        //screen.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen7.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen7.setTheatre(theatre3);
//        screenRepository.save(screen7);
////
//        Screen screen8 = new Screen();
//        screen8.setName("PVR Screen 8");
//        // screen2.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen8.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen8.setTheatre(theatre3);
//        screenRepository.save(screen8);
//
//        Screen screen9 = new Screen();
//        screen9.setName("PVR Screen 9");
//        // screen3.setSeats(Arrays.asList(seat,seat2,seat3));
//        screen9.setFeatures(Arrays.asList(Feature.IMAX,Feature.HD));
//        screen9.setTheatre(theatre3);
//        screenRepository.save(screen9);
//
//
//
//        Seat seat = new Seat();
//        seat.setRowval(1);
//        seat.setColval(1);
//        seat.setSeatNumber("A1");
//        seat.setSeatType(SeatType.GOLD);
//        seat.setScreen(screen);
//        seatRepository.save(seat);
//
//        Seat seat2 = new Seat();
//        seat2.setRowval(2);
//        seat2.setColval(1);
//        seat2.setSeatNumber("B1");
//        seat2.setSeatType(SeatType.SILVER);
//        seat2.setScreen(screen);
//        seatRepository.save(seat2);
//
//        Seat seat3 = new Seat();
//        seat3.setRowval(3);
//        seat3.setColval(1);
//        seat3.setSeatNumber("C1");
//        seat3.setSeatType(SeatType.RECLINER);
//        seat3.setScreen(screen);
//        seatRepository.save(seat3);
//
//        Seat seat4 = new Seat();
//        seat4.setRowval(1);
//        seat4.setColval(1);
//        seat4.setSeatNumber("A1");
//        seat4.setSeatType(SeatType.GOLD);
//        seat4.setScreen(screen2);
//        seatRepository.save(seat4);
//
//        Seat seat5 = new Seat();
//        seat5.setRowval(2);
//        seat5.setColval(1);
//        seat5.setSeatNumber("B1");
//        seat5.setSeatType(SeatType.SILVER);
//        seat5.setScreen(screen2);
//        seatRepository.save(seat5);
//
//
//        Seat seat6 = new Seat();
//        seat6.setRowval(1);
//        seat6.setColval(1);
//        seat6.setSeatNumber("C1");
//        seat6.setSeatType(SeatType.RECLINER);
//        seat6.setScreen(screen2);
//        seatRepository.save(seat6);
//
//        Seat seat7 = new Seat();
//        seat7.setRowval(2);
//        seat7.setColval(1);
//        seat7.setSeatNumber("A1");
//        seat7.setSeatType(SeatType.GOLD);
//        seat7.setScreen(screen3);
//        seatRepository.save(seat7);
//
//        Seat seat8 = new Seat();
//        seat8.setRowval(3);
//        seat8.setColval(1);
//        seat8.setSeatNumber("B1");
//        seat8.setSeatType(SeatType.SILVER);
//        seat8.setScreen(screen3);
//        seatRepository.save(seat8);
//
//        Seat seat9 = new Seat();
//        seat9.setRowval(3);
//        seat9.setColval(1);
//        seat9.setSeatNumber("C1");
//        seat9.setSeatType(SeatType.RECLINER);
//        seat9.setScreen(screen3);
//        seatRepository.save(seat9);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//        Date startTime1 = sdf.parse("2024-07-20T10:00:00.674+00:00");
//        Date endTime1 = sdf.parse("2024-07-20T13:00:00.674+00:00");
//        Date startTime2 = sdf.parse("2024-07-20T14:00:00.674+00:00");
//        Date endTime2 = sdf.parse("2024-07-20T17:00:00.674+00:00");
//        Date startTime3 = sdf.parse("2024-07-20T18:00:00.674+00:00");
//        Date endTime3 = sdf.parse("2024-07-20T21:00:00.674+00:00");
//
//        Show show = new Show();
//        show.setMovie(movie);
//        show.setStartTime(startTime1);
//        show.setEndTime(endTime1);
//        show.setScreen(screen);
//        show.setFeatures(Arrays.asList(Feature.IMAX));
//        show.setTheatre(theatre1);
//        showRepository.save(show);
//
//        Show show2 = new Show();
//        show2.setMovie(movie);
//        show2.setStartTime(startTime2);
//        show2.setEndTime(endTime2);
//        show2.setScreen(screen2);
//        show.setTheatre(theatre1);
//        show2.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show2);
//
//        Show show3 = new Show();
//        show3.setMovie(movie);
//        show3.setStartTime(startTime3);
//        show3.setEndTime(endTime3);
//        show3.setScreen(screen3);
//        show3.setTheatre(theatre1);
//        show3.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show3);
//
//
//        Show show4 = new Show();
//        show4.setMovie(movie);
//        show4.setStartTime(new Date());
//        show4.setEndTime(new Date());
//        show4.setScreen(screen2);
//        show4.setFeatures(Arrays.asList(Feature.IMAX));
//        show4.setTheatre(theatre2);
//        showRepository.save(show4);
//
//        Show show5 = new Show();
//        show5.setMovie(movie);
//        show5.setStartTime(new Date());
//        show5.setEndTime(new Date());
//        show5.setScreen(screen2);
//        show5.setTheatre(theatre2);
//        show5.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show5);
//
//        Show show6 = new Show();
//        show6.setMovie(movie);
//        show6.setStartTime(new Date());
//        show6.setEndTime(new Date());
//        show6.setScreen(screen2);
//        show6.setTheatre(theatre2);
//        show6.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show6);
//
//        Show show7 = new Show();
//        show7.setMovie(movie3);
//        show7.setStartTime(new Date());
//        show7.setEndTime(new Date());
//        show7.setScreen(screen);
//        show7.setFeatures(Arrays.asList(Feature.IMAX));
//        show7.setTheatre(theatre2);
//        showRepository.save(show7);
//
//        Show show8 = new Show();
//        show8.setMovie(movie3);
//        show8.setStartTime(new Date());
//        show8.setEndTime(new Date());
//        show8.setScreen(screen);
//        show8.setTheatre(theatre2);
//        show8.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show8);
//
//        Show show9 = new Show();
//        show9.setMovie(movie3);
//        show9.setStartTime(new Date());
//        show9.setEndTime(new Date());
//        show9.setScreen(screen);
//        show9.setTheatre(theatre2);
//        show9.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show9);
//
//
//        Show show10 = new Show();
//        show10.setMovie(movie2);
//        show10.setStartTime(new Date());
//        show10.setEndTime(new Date());
//        show10.setScreen(screen2);
//        show10.setFeatures(Arrays.asList(Feature.IMAX));
//        show10.setTheatre(theatre2);
//        showRepository.save(show10);
//
//        Show show11 = new Show();
//        show11.setMovie(movie2);
//        show11.setStartTime(new Date());
//        show11.setEndTime(new Date());
//        show11.setScreen(screen2);
//        show11.setTheatre(theatre2);
//        show11.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show11);
//
//        Show show12 = new Show();
//        show12.setMovie(movie2);
//        show12.setStartTime(new Date());
//        show12.setEndTime(new Date());
//        show12.setScreen(screen2);
//        show12.setTheatre(theatre2);
//        show12.setFeatures(Arrays.asList(Feature.IMAX));
//        showRepository.save(show12);
















    }
}