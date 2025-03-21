# 📱 안드로이드에서 XML 파일로 사용자 인터페이스 작성하기

안드로이드에서는 **XML 파일**을 사용하여 **사용자 인터페이스(UI)**를 정의합니다.  
XML 레이아웃 파일은 앱의 화면 구성 요소(버튼, 텍스트, 이미지 등)를 정의하고, 각 요소의 속성도 설정할 수 있습니다.

---

## 📌 1. 기본 레이아웃 구조

안드로이드의 레이아웃 파일은 **`res/layout`** 폴더 안에 위치하며, 주로 **XML** 형식으로 작성됩니다.  
가장 일반적으로 사용되는 레이아웃 타입은 **`LinearLayout`**, **`RelativeLayout`**, **`ConstraintLayout`** 등이 있습니다.

LinearLayout: 위젯들이 세로로 정렬되는 레이아웃입니다. android:orientation="vertical"을 사용하여 위젯을 세로로 배치합니다.
TextView: 텍스트를 화면에 표시하는 위젯입니다. android:text 속성으로 텍스트를 설정합니다.
EditText: 사용자가 텍스트를 입력할 수 있는 필드입니다. android:hint 속성으로 입력 안내 텍스트를 표시합니다.
Button: 클릭 가능한 버튼입니다. android:text 속성으로 버튼에 표시되는 텍스트를 설정합니다.

![Image](https://github.com/user-attachments/assets/eafc8ef4-58bf-4f06-a6cd-8a44792b88c1)
