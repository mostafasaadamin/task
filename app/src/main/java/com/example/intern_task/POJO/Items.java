package com.example.intern_task.POJO;
public  class Items {
    private final String kind;

    private final String etag;

    private final Id id;

    public Items(String kind, String etag, Id id) {
        this.kind = kind;
        this.etag = etag;
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public Id getId() {
        return id;
    }

    public static class Id {
        private final String kind;

        private final String videoId;

        public Id(String kind, String videoId) {
            this.kind = kind;
            this.videoId = videoId;
        }

        public String getKind() {
            return kind;
        }

        public String getVideoId() {
            return videoId;
        }
    }
}