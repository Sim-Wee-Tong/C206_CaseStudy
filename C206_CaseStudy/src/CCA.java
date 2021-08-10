/**
 * I declare that this code was written by me 2021-Aug-09 11:36:18 am 
 * @author Anirudh 20040878}
 * 
 */

 

public class CCA {
    
    private String title;
    private String description;
    private int size;
    private String dayOfW;
    private String time;
    private String venue;
    private String instructorName;
    
    public CCA(String title, String description, int size, String dayOfW, String time, String venue,
            String instructorName) {
        this.title = title;
        this.description = description;
        this.size = size;
        this.dayOfW = dayOfW;
        this.time = time;
        this.venue = venue;
        this.instructorName = instructorName;
    }
    public String getTitle() {
        return title;
    }

 

    public String getDescription() {
        return description;
    }

 

    public int getSize() {
        return size;
    }

 

    public String getDayOfW() {
        return dayOfW;
    }

 

    public String getTime() {
        return time;
    }

 

    public String getVenue() {
        return venue;
    }

 

    public String getInstructorName() {
        return instructorName;
    }

 

    
    
}