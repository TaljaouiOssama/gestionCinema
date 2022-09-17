package com.ossama.gestioncinema.services;

import com.ossama.gestioncinema.dao.*;
import com.ossama.gestioncinema.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.*;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
@Transactional
public class IInitServiceImpl implements  IInitService{
    private CityRepository cityRepository;
    private CinemaRepository cinemaRepository;
    private TheaterRepository theaterRepository;
    private SeatRepository seatRepository;
    private SessionRepository sessionRepository;
    private CategoryRepository categoryRepository;
    private MovieRepository movieRepository;
    private MovieProjectionRepository movieProjectionRepository;
    private TicketRepository ticketRepository;
    @Override
    public void initCities() {
        Stream.of("Casablanca","Rabat","Sale","Tanger","Agadir").forEach(cityName->{
            City c=new City();
            c.setName(cityName);
            cityRepository.save(c);
        });
    }

    @Override
    public void initCinemas() {
        cityRepository.findAll().forEach(city -> {
            Stream.of("Carablanca","Shahrasad","Roma").forEach(cinemaName->{
                Cinema c=new Cinema();
                c.setName(cinemaName);
                c.setNbrTheater(3+(int)(Math.random()*7));
                c.setCity(city);
                cinemaRepository.save(c);
            });
        });
    }

    @Override
    public void initTheaters() {
        cinemaRepository.findAll().forEach(cinema -> {
            for(int i=0;i<cinema.getNbrTheater();i++){
                Theater t=new Theater();
                t.setName(cinema.getName()+" : Theater : "+i);
                t.setNbrSeats(30+(int)(Math.random()*30));
                t.setCinema(cinema);
                theaterRepository.save(t);
            }
        });
    }

    @Override
    public void initSeats() {
        theaterRepository.findAll().forEach(theater -> {
            for(int i=0;i<theater.getNbrSeats();i++){
                Seat s=new Seat();
                s.setTheater(theater);
                s.setNumber(i);
                seatRepository.save(s);
            }
        });

    }

    @Override
    public void initSessions() {
        DateFormat df=new SimpleDateFormat("HH:mm");
        Stream.of("12:00","14:00","16:00","18:00","20:00","22:00").forEach(sessionTime->{
            Session s=new Session();
            try {
                s.setBeginningHour(df.parse(sessionTime));
                sessionRepository.save(s);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        });




    }



    @Override
    public void initCategories() {
        Stream.of("History","Action","Drama","Comedy","Fiction").forEach(categoryName->{
            Category c=new Category();
            c.setName(categoryName);
            categoryRepository.save(c);
        });

    }

    @Override
    public void initMovies() {
        double d[]={1,1.5,2,2.5,3};
        List<Category> c=categoryRepository.findAll();
        Stream.of("Jumber","The Old Guard","Carnaval","Private Life","The Witcher","Hulk").forEach(movieName->{
            Movie m= new Movie();
            m.setTitle(movieName);
            m.setDuration(d[new Random().nextInt(d.length)]);
            m.setCategory(c.get(new Random().nextInt(c.size())));
            m.setPicture(m.getTitle().replace(" ",""));
            movieRepository.save(m);
        });

    }

    @Override
    public void initMoviesProjection() {
        double p[]={100,150,50,200,70,80,30};
        cityRepository.findAll().forEach(city -> {
            city.getCinemaList().forEach(cinema -> {
                cinema.getTheaterList().forEach(theater -> {
                    movieRepository.findAll().forEach(movie -> {
                        sessionRepository.findAll().forEach(session -> {
                            MovieProjection mp=new MovieProjection();
                            mp.setMovie(movie);
                            mp.setTheater(theater);
                            mp.setProjectionDate(new Date());
                            mp.setPrice(p[new Random().nextInt(p.length)]);
                            mp.setSession(session);
                            movieProjectionRepository.save(mp);


                        });
                    });
                });
            });
        });

    }

    @Override
    public void initTickets() {
            movieProjectionRepository.findAll().forEach(movieProjection -> {
                movieProjection.getTheater().getSeatList().forEach(seat -> {
                    Ticket t= new Ticket();
                    t.setMovieProjection(movieProjection);
                    t.setPrice(movieProjection.getPrice());
                    t.setSeat(seat);
                    t.setReserved(false);
                    ticketRepository.save(t);

                });
            });
    }
}
