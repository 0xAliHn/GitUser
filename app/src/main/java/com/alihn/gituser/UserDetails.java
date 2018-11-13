package com.alihn.gituser;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.squareup.moshi.Json;

public class UserDetails implements Parcelable {

    public final static Parcelable.Creator<UserDetails> CREATOR = new Creator<UserDetails>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserDetails createFromParcel(@NonNull Parcel in) {
            return new UserDetails(in);
        }

        public UserDetails[] newArray(int size) {
            return (new UserDetails[size]);
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
    @Json(name = "name")
    private String name;
    @Nullable
    @Json(name = "company")
    private String company;
    @Nullable
    @Json(name = "blog")
    private String blog;
    @Nullable
    @Json(name = "location")
    private String location;
    @Nullable
    @Json(name = "email")
    private Object email;
    @Nullable
    @Json(name = "hireable")
    private Object hireable;
    @Nullable
    @Json(name = "bio")
    private Object bio;
    @Nullable
    @Json(name = "public_repos")
    private Integer publicRepos;
    @Nullable
    @Json(name = "public_gists")
    private Integer publicGists;
    @Nullable
    @Json(name = "followers")
    private Integer followers;
    @Nullable
    @Json(name = "following")
    private Integer following;
    @Nullable
    @Json(name = "created_at")
    private String createdAt;
    @Nullable
    @Json(name = "updated_at")
    private String updatedAt;

    protected UserDetails(Parcel in) {
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
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.company = ((String) in.readValue((String.class.getClassLoader())));
        this.blog = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.email = in.readValue((Object.class.getClassLoader()));
        this.hireable = in.readValue((Object.class.getClassLoader()));
        this.bio = in.readValue((Object.class.getClassLoader()));
        this.publicRepos = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.publicGists = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.followers = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.following = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserDetails() {
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Nullable
    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Nullable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Nullable
    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    @Nullable
    public Object getHireable() {
        return hireable;
    }

    public void setHireable(Object hireable) {
        this.hireable = hireable;
    }

    @Nullable
    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    @Nullable
    public Integer getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(Integer publicRepos) {
        this.publicRepos = publicRepos;
    }

    @Nullable
    public Integer getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(Integer publicGists) {
        this.publicGists = publicGists;
    }

    @Nullable
    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    @Nullable
    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    @Nullable
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Nullable
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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
        dest.writeValue(name);
        dest.writeValue(company);
        dest.writeValue(blog);
        dest.writeValue(location);
        dest.writeValue(email);
        dest.writeValue(hireable);
        dest.writeValue(bio);
        dest.writeValue(publicRepos);
        dest.writeValue(publicGists);
        dest.writeValue(followers);
        dest.writeValue(following);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
    }

    public int describeContents() {
        return 0;
    }

}