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
| ![Main Dashboard](<img width="1440" height="3060" alt="Screenshot_2026-10-20-16-11-33-768_com example lab9-edit" src="https://github.com/user-attachments/assets/3b743adb-bb53-46ba-bded-2c7b66963666" />
) <!-- ADD MAIN PAGE SCREENSHOT HERE --> | ![View Users](<img width="1440" height="3051" alt="Screenshot_2026-10-20-16-12-02-185_com example lab9-edit" src="https://github.com/user-attachments/assets/11b11dcc-0b60-4a14-a4ef-81feb369d382" />
) <!-- ADD VIEW USERS PAGE SCREENSHOT HERE --> |

| 3️⃣ Update User | 4️⃣ Delete User |
| :---: | :---: |
| ![Update User](<img width="1440" height="3071" alt="Screenshot_2026-10-20-16-12-11-869_com example lab9-edit" src="https://github.com/user-attachments/assets/f8ef3cc4-83c8-4bf1-ac7a-9d6653fdc39b" />
) <!-- ADD UPDATE PAGE SCREENSHOT HERE --> | ![Delete User](<img width="1440" height="3060" alt="Screenshot_2026-10-20-16-12-19-694_com example lab9-edit" src="https://github.com/user-attachments/assets/707ccdcf-1165-410b-828a-5b77e26ec3ac" />
) <!-- ADD DELETE PAGE SCREENSHOT HERE --> |

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
