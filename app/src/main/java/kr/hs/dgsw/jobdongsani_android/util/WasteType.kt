package kr.hs.dgsw.jobdongsani_android.util

object WasteType {

    val wasteType = HashMap<String, String>().apply {
        put("플라스틱류", "페트병과 플라스틱 용기에 든 내용물은 깨끗이 비우고, \n" +
                "부착상표와 뚜겅 등 다른 재질로 된 부분은 제거.\n" +
                "단, 알약 포장제와 카세트레이프 등 여러 재질이 섞이고 \n" +
                "분리가 어려운 제품은 종랑제봉투에 담아 버림.")
        put("비닐류", "과자, 라면봉지, 1회용 비닐봉투에 음식물과 이물질이 묻었다면\n" +
                "물로 2~3번 헹궈 잔여물을 없애고 버리고,\n" +
                "이물질 제거가 어려운 경우에는 종량제봉투에 배출")
        put("스티로폼", "라면 국물이 밴 컵라면 용기는 남아있는 음식물 찌꺼기를 물에 한번 행군 후 버리고,\n" +
                "농·수·축산물의 포장에 사용된 스티로폼은 내용물을 완전히 비우고\n" +
                "테이프나 운송장, 상표 등을 완전히 제거한 뒤 버려야 함.\n" +
                "이물질이 많이 묻었다면 스티로폼을 쪼개 종량제봉투에 담아 버림.\n")
        put("유리병류", "탄산음료병이나 맥주병, 소주병은 담배꽁초와 같은 이물질을 넣지 말고 버림.\n" +
                "하지만 거울, 깨진 유리, 도자기류,유리 식기류는 유리병류가 아니기 때문에\n" +
                "종량제봉투나 전용 마대에 버림.")
        put("종이류",
            "신문지, 책자, 종이, 상자류, 달력포장지의 경우엔 물기, 비닐코팅, 스프링, 테이프, 철판 등은 제거 후 반듯하게 펴서 차곡차곡 묶음.\n" +
                    "종이컵/우유팩의 경우엔 내용물을 깨끗이 비우고 압착하여 배출(종이류와 따로 분리배출)\n")
        put("병류", "병뚜껑 제거 후 내용물을 비우고 물로 헹궈 배출(담배꽁초 등 이물질 넣지 말 것)\n" +
                "*깨진병은 재활용 안됨")
        put("캔/금속류", "물로 헹구어 가능한 한 압착하여 배출\n" +
                "*부탄가스등은 구멍을 내어 배출")
        put("의류", "물에 젖지 않도록 비닐봉투에 넣어 배출하거나 의류수거함에 배출\n" +
                "*그물망 또는 투명비닐에 배출")

    }

}