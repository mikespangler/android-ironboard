package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by spangler on 12/16/14.
 */
public class Schedules {

// {"schedules":{"0":{"content":"# Wednesday, November 26th - Day 42\n\nThe plan      |  |\n--------------|----------------------------------------------------------------\n9:00  - 10:00
// | Standups\n10:00 - 12:00 | Working on projects\n12:00 - 1:00  | Lunch\n1:00  - 2:00  | Quad for Chris Whong of Socrata will talk about civic hacking\n2:00  - 4:00
// | Working on projects\n4:00  - 4:15  | Prep for Final Demos\n4:15  - 5:00  | Project One Demos!\n\n## Have a Happy Thanksgiving!\n","date":"Dec 12 2014"}
// ,"1":{"content":"# Tuesday, November 25th - Day 41\n\nThe plan      |      |\n--------------|-----------------------------------\n9:00  - 9:30  | Standups\n9:30 - 10:15
// | Blog Posts\n10:15 - 10:30 | Finish standups\n10:00 - 12:00 | Working on projects\n12:00 - 1:00  | Lunch\n1:00  - 2:00  | Working on projects\n2:00  - 2:30  | Placements talk\n2:30  - 5:15
// | Working on projects\n5:15  - 5:30  | Prep for retro\n5:30  - 6:00  | Retro (4 groups, 5 minutes each)\n6:30  - 7:30  | Flatiron Presents\n","date":"Dec 12 2014"}}

    @SerializedName("data")
    private List<Schedule> data;

    public List<Schedule> getData() {
        return data;
    }

    public class Schedule {

        @SerializedName("date")
        private String mDate;

        @SerializedName("content")
        private String mContent;

        public String getDate() {
            return mDate;
        }

        public String getContent() {
            return mContent;
        }

    }
}
