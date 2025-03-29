# 동적 UI 구현 예제: 버튼 클릭 시 텍스트 뷰 추가

이 예제에서는 **`LinearLayout`**을 사용하여 버튼 클릭 시 동적으로 텍스트 뷰를 추가하는 방법을 설명합니다. 버튼을 클릭할 때마다 새로운 텍스트 뷰가 레이아웃에 추가됩니다.

## 1. XML 레이아웃 파일

**`activity_main.xml`**에서 기본 레이아웃을 구성합니다. 이 레이아웃은 버튼과 텍스트 뷰를 포함할 공간을 제공합니다. 버튼을 클릭하면 새로운 텍스트 뷰가 `LinearLayout`에 추가됩니다.

**MainActivity.java**에서 버튼 클릭 시 텍스트 뷰를 동적으로 추가하는 로직을 구현합니다.

![Image](https://github.com/user-attachments/assets/ae6090f2-1951-47a6-84a6-e8c34a9362cb)
