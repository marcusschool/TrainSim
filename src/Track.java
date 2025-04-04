public class Track extends SimObject {
    private Track nextTrack;
    private boolean isNextToStation;
    private boolean isEmpty;
    private Station stationNextToTrack;
    private int angle;

    public void setNextTrack(Track _nextTrack)
    {
        this.nextTrack = _nextTrack;
    }

    public Track getNextTrack()
    {
        return this.nextTrack;
    }

    public boolean isNextToStation()
    {
        return this.isNextToStation;
    }

    public boolean isEmpty()
    {
        return this.isEmpty;
    }

    public void setStationNextToTrack(Station _stationNextToTrack)
    {
        this.stationNextToTrack = _stationNextToTrack;
    }

    public Station getStationNextToTrack()
    {
        return this.stationNextToTrack;
    }

    public int getAngle()
    {
        return this.angle;
    }
}
