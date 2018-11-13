package com.alihn.gituser;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.squareup.moshi.Json;

public class User implements Parcelable {

    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(@NonNull Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    };
    @Nullable
    @Json(name = "login")
    private String login;
    @Nullable
    @Json(name = "id")
    private Integer id;
    @Nullable
    @Json(name = "node_id")
    private String nodeId;
    @Nullable
    @Json(name = "avatar_url")
    private String avatarUrl;
    @Nullable
    @Json(name = "gravatar_id")
    private String gravatarId;
    @Nullable
    @Json(name = "url")
    private String url;
    @Nullable
    @Json(name = "html_url")
    private String htmlUrl;
    @Nullable
    @Json(name = "followers_url")
    private String followersUrl;
    @Nullable
    @Json(name = "following_url")
    private String followingUrl;
    @Nullable
    @Json(name = "gists_url")
    private String gistsUrl;
    @Nullable
    @Json(name = "starred_url")
    private String starredUrl;
    @Nullable
    @Json(name = "subscriptions_url")
    private String subscriptionsUrl;
    @Nullable
    @Json(name = "organizations_url")
    private String organizationsUrl;
    @Nullable
    @Json(name = "repos_url")
    private String reposUrl;
    @Nullable
    @Json(name = "events_url")
    private String eventsUrl;
    @Nullable
    @Json(name = "received_events_url")
    private String receivedEventsUrl;
    @Nullable
    @Json(name = "type")
    private String type;
    @Nullable
    @Json(name = "site_admin")
    private Boolean siteAdmin;
    @Nullable
    @Json(name = "score")
    private Integer score;

    protected User(Parcel in) {
        this.login = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nodeId = ((String) in.readValue((String.class.getClassLoader())));
        this.avatarUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.gravatarId = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.htmlUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.followersUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.followingUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.gistsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.starredUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.subscriptionsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.reposUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.eventsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.receivedEventsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.siteAdmin = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.score = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public User() {
    }

    @Nullable
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Nullable
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @Nullable
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Nullable
    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Nullable
    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @Nullable
    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    @Nullable
    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    @Nullable
    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    @Nullable
    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    @Nullable
    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    @Nullable
    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    @Nullable
    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    @Nullable
    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    @Nullable
    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    @Nullable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Nullable
    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    @Nullable
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeValue(login);
        dest.writeValue(id);
        dest.writeValue(nodeId);
        dest.writeValue(avatarUrl);
        dest.writeValue(gravatarId);
        dest.writeValue(url);
        dest.writeValue(htmlUrl);
        dest.writeValue(followersUrl);
        dest.writeValue(followingUrl);
        dest.writeValue(gistsUrl);
        dest.writeValue(starredUrl);
        dest.writeValue(subscriptionsUrl);
        dest.writeValue(organizationsUrl);
        dest.writeValue(reposUrl);
        dest.writeValue(eventsUrl);
        dest.writeValue(receivedEventsUrl);
        dest.writeValue(type);
        dest.writeValue(siteAdmin);
        dest.writeValue(score);
    }

    public int describeContents() {
        return 0;
    }

}