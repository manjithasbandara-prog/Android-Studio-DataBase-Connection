# 📱 User Directory - Android SQLite App

A modern, trendy Android application designed with **Material Design 3** and local **SQLite Database** integration to perform complete **CRUD** (Create, Read, Update, Delete) operations.

---

## 📸 Application Screenshots

<!-- ========================================================================================= -->
<!-- 🖼️ ADD YOUR SCREENSHOTS BELOW!                                                           -->
<!-- Replace 'path/to/your_image.png' with the relative path or URL to your actual screenshots. -->
<!-- ========================================================================================= -->

| 1️⃣ Main Dashboard | 2️⃣ View Users List |
| :---: | :---: |
| ![Main Dashboard](path/to/main_dashboard.png) <!-- ADD MAIN PAGE SCREENSHOT HERE --> | ![View Users](path/to/view_users.png) <!-- ADD VIEW USERS PAGE SCREENSHOT HERE --> |

| 3️⃣ Update User | 4️⃣ Delete User |
| :---: | :---: |
| ![Update User](path/to/update_user.png) <!-- ADD UPDATE PAGE SCREENSHOT HERE --> | ![Delete User](path/to/delete_user.png) <!-- ADD DELETE PAGE SCREENSHOT HERE --> |

<!-- ========================================================================================= -->

---

## ✨ Features

- 🎨 **Modern Material 3 Design**: Features gradient headers, card elevation, soft backgrounds, and pill-shaped action buttons.
- ➕ **Add User**: Insert user data (`Name` and `Age`) securely into local SQLite storage.
- 📋 **View Users List**: Custom `RecyclerView` displaying user records with circular ID badges, clean card views, and staggered entrance animations.
- 🔍 **Empty State Indicator**: Displays a clean empty-state visual when no records exist in the database.
- ✏️ **Update User**: Seamlessly update existing user details by ID.
- 🗑️ **Delete User**: Remove user records safely by ID with soft red warning accents.
- 🛡️ **Input Validation & Safety**: Built-in validation preventing empty inputs, invalid age/ID formats, and unexpected crashes.

---

## 🛠️ Built With

- **Language**: Java
- **UI Framework**: Android XML, Material Design 3 (`MaterialCardView`, `TextInputLayout`, `MaterialButton`)
- **Database**: SQLite (`SQLiteOpenHelper`)
- **Components**: `RecyclerView`, `CoordinatorLayout`, `NestedScrollView`
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 37

---

## 🗄️ Database Schema

**Database Name**: `User.db`  
**Table**: `users`

| Column | Type | Constraints | Description |
| :--- | :--- | :--- | :--- |
| `id` | `INTEGER` | `PRIMARY KEY AUTOINCREMENT` | Auto-generated unique User ID |
| `name` | `TEXT` | `NOT NULL` | User's full name |
| `age` | `INTEGER` | `NOT NULL` | User's age |

---

## 🚀 How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/lab9.git
   ```
2. **Open in Android Studio**:
   - Select **Open an existing Project** and navigate to the cloned project folder.
3. **Sync & Build**:
   - Allow Gradle to sync dependencies automatically.
4. **Run App**:
   - Select your emulator or connected physical Android device and click **Run (Shift + F10)**.

---

## 📝 License

This project is open-source and available under the [MIT License](LICENSE).
