# Android Studio 비주얼 도구로 화면 만들기

## 개요
Android Studio의 레이아웃 에디터를 사용하여 드래그 앤 드롭으로 UI를 구성하는 방법에 대한 가이드입니다.

## 시작하기

### 1. 레이아웃 파일 열기
- `app/src/main/res/layout/` 폴더에서 XML 레이아웃 파일을 더블클릭
- 또는 새 레이아웃 파일 생성: `File > New > Android Resource File`

### 2. 디자인 모드로 전환
- 레이아웃 에디터 하단의 **Design** 탭 클릭
- Split 모드를 사용하면 디자인과 코드를 동시에 볼 수 있음

## 위젯 배치하기

### Palette 패널 사용
1. 왼쪽 **Palette** 패널에서 원하는 위젯 선택
2. 위젯을 마우스로 클릭한 채로 드래그
3. 디자인 캔버스의 원하는 위치에 드롭

### 주요 위젯 카테고리
- **Text**: TextView, EditText, Button 등
- **Layouts**: LinearLayout, RelativeLayout, ConstraintLayout 등
- **Images**: ImageView, ImageButton 등
- **Containers**: ScrollView, RecyclerView 등

## Infer Constraints 기능

### 사용 시점
- ConstraintLayout에서 여러 위젯을 배치한 후
- 위젯들이 제약조건(constraints) 없이 배치되어 있을 때

### 사용 방법
1. 위젯들을 원하는 위치에 배치
2. 툴바에서 **Infer Constraints** 버튼 클릭 (🔗 아이콘)
3. Android Studio가 자동으로 적절한 제약조건을 생성

### Infer Constraints의 장점
- 수동으로 제약조건을 설정할 필요 없음
- 다양한 화면 크기에서 일관된 레이아웃 유지
- 빠른 프로토타이핑 가능

## 추가 팁

### 제약조건 수동 설정
- 위젯을 선택하고 모서리의 원형 핸들을 드래그
- 부모 레이아웃이나 다른 위젯에 연결

### 속성 패널 활용
- 오른쪽 **Attributes** 패널에서 세부 속성 조정
- 텍스트, 색상, 크기, 마진 등 설정

### 미리보기 기능
- 다양한 기기 크기와 방향으로 미리보기
- 툴바의 기기 선택 드롭다운 메뉴 활용

## 주의사항
- ConstraintLayout 사용 시 모든 위젯은 최소 2개의 제약조건 필요 (가로, 세로 각 1개씩)
- Infer Constraints는 완벽하지 않으므로 결과를 확인하고 필요시 수동 조정
- 복잡한 레이아웃의 경우 단계적으로 제약조건 설정 권장

## 결론
Android Studio의 비주얼 도구와 Infer Constraints 기능을 활용하면 코드 작성 없이도 직관적으로 UI를 구성할 수 있습니다. 특히 ConstraintLayout과 함께 사용하면 반응형 레이아웃을 쉽게 만들 수 있습니다.
