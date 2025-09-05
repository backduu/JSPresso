erDiagram
    %% 사용자
    USERS {
        int id PK
        varchar username
        varchar password
        varchar nickname
        varchar role
        varchar status
        timestamp created_at
        timestamp approved_at
    }

    %% 팔로우 관계
    FOLLOWS {
        int following_user_id FK
        int followed_user_id FK
        timestamp created_at
    }

    %% 게시글
    POSTS {
        int id PK
        varchar title
        text body
        int user_id FK
        varchar status
        timestamp created_at
    }

    %% 채팅방
    CHATROOMS {
        int id PK
        varchar room_name
        varchar type
        timestamp created_at
    }

    %% 채팅방 참여자
    CHATROOM_PARTICIPANTS {
        int chatroom_id FK
        int user_id FK
    }

    %% 메시지
    MESSAGES {
        int id PK
        text content
        varchar type
        int sender_id FK
        int chatroom_id FK
        timestamp sent_at
    }

    %% 과제
    ASSIGNMENTS {
        int id PK
        varchar title
        text description
        int creator_id FK
        timestamp created_at
        timestamp due_date
    }

    %% 제출물
    SUBMISSIONS {
        int id PK
        int assignment_id FK
        int student_id FK
        timestamp submitted_at
        varchar file_url
        int grade
        varchar status
    }

    %% 알림
    HISTORY {
        int id PK
        int user_id FK
        text content
        varchar type
        boolean is_read
        varchar related_url
        timestamp created_at
    }

    %% 관계 정의
    USERS ||--o{ POSTS : "writes"
    USERS ||--o{ FOLLOWS : "follows (as follower)"
    USERS ||--o{ FOLLOWS : "followed by (as followee)"
    USERS ||--o{ CHATROOM_PARTICIPANTS : "joins"
    CHATROOMS ||--o{ CHATROOM_PARTICIPANTS : "has participants"
    USERS ||--o{ MESSAGES : "sends"
    CHATROOMS ||--o{ MESSAGES : "contains"
    USERS ||--o{ ASSIGNMENTS : "creates"
    ASSIGNMENTS ||--o{ SUBMISSIONS : "has"
    USERS ||--o{ SUBMISSIONS : "submits"
    USERS ||--o{ HISTORY : "receives"
