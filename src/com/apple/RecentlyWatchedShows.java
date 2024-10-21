/**
 * Problem Statement
 * 
 * Maintain a list of recently watched shows such that:
 * 1. If the user has started watching a show it must be displayed at the
 * top/front of the list
 * 2. If the show being watched by the user was already in the list of recently
 * watched shows, it must be moved to the top of the list.
 * 3. If the show being watched by the user user was not already in the list, it
 * should be added to the top/front of the list
 * 4. If the size of the recently watched shows exceed a certain limit, the last
 * show in the list should be popped.
 * 
 * Implement the following methods to complete the above requirements.
 */

package com.apple;

public class RecentlyWatchedShows {

    public RecentlyWatchedShows(int capacity) {

    }

    public void put(Integer id, String showName) {

    }

    public Show get(Integer id) {
        return null;
    }
}

class Show {
    int id;
    String showName;

    public Show(int id, String showName) {
        this.id = id;
        this.showName = showName;
    }
}