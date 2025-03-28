import java.util.ArrayList;

public class TrainController {
    private final int amountOfTracksBetweenStations = 2;
    private final int amountOfStations = 4;
    private final int amountOfTracksPerStation = 2;
    private final int amountOfTrains = 4;
    private final int gameTicksPerMilliseconds = 1000;
    private boolean gameIsRunning = false; // DON'T DO IT FINAL, PLEASE

    private final ArrayList<SimObject> simObjects = new ArrayList<>();
    private final ArrayList<Track> tracks = new ArrayList<>();
    private final ArrayList<Station> stations = new ArrayList<>();
    private final ArrayList<Train> trains = new ArrayList<>();

    TrainController()
    {
        createTracks();
        linkTracks();
        createStations();
        addStationsToTrack();
        createTrains();
        startGameTick();
    }

    private void createTracks()
    {
        int amountOfTracks = amountOfStations * amountOfTracksBetweenStations;
        for (int i = 0; i < amountOfTracks; i++)
        {
            Track _track = new Track();
            tracks.add(_track);
            simObjects.add(_track);
        }
    }

    private void linkTracks()
    {
        int _lastTrackIndex = tracks.size() - 1;
        Track _lastTrack = tracks.get(_lastTrackIndex);
        tracks.get(0).setPreviousTrack(_lastTrack);
        tracks.get(0).setNextTrack(tracks.get(1));
        tracks.get(_lastTrackIndex).setPreviousTrack(tracks.get(_lastTrackIndex-1));
        tracks.get(_lastTrackIndex).setNextTrack(tracks.get(1));
        for (int i = 1; i < tracks.size()-1; i++)
        {
            Track _track = tracks.get(i);
            Track _previousTrack = tracks.get(i-1);
            Track _nextTrack = tracks.get(i+1);
            _track.setPreviousTrack(_previousTrack);
            _track.setNextTrack(_nextTrack);
        }
    }

    private void createStations()
    {
        for (int i = 0; i < amountOfStations; i++)
        {
            Station.setAmountOfTracksPerStation(amountOfTracksPerStation);
            Station _station = new Station();
            stations.add(_station);
            simObjects.add(_station);
        }
    }

    private void addStationsToTrack()
    {
        for (int i = 0; i < amountOfStations; i++)
        {
            Track _track = tracks.get(i*amountOfTracksBetweenStations);
            Station _station = stations.get(i);
            _track.setStationNextToTrack(_station);
            simObjects.add(_track);
        }
    }

    private void createTrains()
    {
        for (int i = 0; i < amountOfTrains; i++)
        {
            Train _train = new Train(stations);
            trains.add(_train);
            simObjects.add(_train);
        }
    }

    private void startGameTick()
    {
        long _lastExecution = System.currentTimeMillis();
        while (gameIsRunning)
        {
            if (System.currentTimeMillis() - _lastExecution >= gameTicksPerMilliseconds)
            {
                gameTick();
                _lastExecution = System.currentTimeMillis();
            }
        }
    }

    private void gameTick()
    {
        for (int i = 0; i < simObjects.size(); i++)
        {
            SimObject simObject = simObjects.get(i);
            simObject.gameTick();
        }
    }
}
