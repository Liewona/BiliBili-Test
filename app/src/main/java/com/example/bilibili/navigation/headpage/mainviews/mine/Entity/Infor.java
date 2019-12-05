package com.example.bilibili.navigation.headpage.mainviews.mine.Entity;

public class Infor {
    public int getHead_source() {
        return head_source;
    }

    public void setHead_source(int head_source) {
        this.head_source = head_source;
    }

    public String getFollowyet() {
        return followyet;
    }

    public void setFollowyet(String followyet) {
        this.followyet = followyet;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    int head_source;
    String nickname;
    String word;
    String followyet;
}
