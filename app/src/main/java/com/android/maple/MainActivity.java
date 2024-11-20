package com.android.maple;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.maple.gamedto.GameCurrencyDisplayDTO;
import com.android.maple.ui.UIMenuMain;
import com.android.maple.view.UIDialogRecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          (new UIMenuMain(this)).show();
     //   UIDialogRecyclerView<GameCurrencyDisplayDTO> dialogComponent = new UIDialogRecyclerView<>(this);

  //    initCustomView(dialogComponent);
  //    setContentView(dialogComponent.getView());
    }

    private void initCustomView(UIDialogRecyclerView<GameCurrencyDisplayDTO> customView) {

        TypeToken<List<GameCurrencyDisplayDTO>> typeToken = new TypeToken<List<GameCurrencyDisplayDTO>>(){};

        String json = "[{\"DisplayCategory\":\"GEM\",\"DisplayName\":\"灵石\",\"DisplayDesc\":\"灵石由特殊的矿石加工而成，比金币更加稀有，具有特殊的力量，可在修行台吸收，也可在特殊商店处交易物品。\",\"ObjectId\":\"GEM\"},{\"DisplayCategory\":\"COIN\",\"DisplayName\":\"金币\",\"DisplayDesc\":\"金币由特殊的矿石加工而成，作为通用的货币，可在所有商人处购买物品。\",\"ObjectId\":\"COIN\"},{\"DisplayCategory\":\"HeartStone\",\"DisplayName\":\"同心石\",\"DisplayDesc\":\"与玉树神像互动，消耗同心石即可进行祈福，祈福会获得石材，天赋玉，妖灵蛋等物品。提升妖灵的好感度会获得同心石。\",\"ObjectId\":\"HeartStone\"},{\"DisplayCategory\":\"REIKI\",\"DisplayName\":\"灵气\",\"DisplayDesc\":\"战斗结束后，出战妖精损失的生命将通过御妖师的灵气进行补充。灵龛和野外神像都可恢复灵气。灵气上限随御妖师等阶提升而上升。\",\"ObjectId\":\"REIKI\"},{\"DisplayCategory\":\"GEM\",\"DisplayName\":\"灵石\",\"DisplayDesc\":\"灵石由特殊的矿石加工而成，比金币更加稀有，具有特殊的力量，可在修行台吸收，也可在特殊商店处交易物品。\",\"ObjectId\":\"GEM\"},{\"DisplayCategory\":\"COIN\",\"DisplayName\":\"金币\",\"DisplayDesc\":\"金币由特殊的矿石加工而成，作为通用的货币，可在所有商人处购买物品。\",\"ObjectId\":\"COIN\"},{\"DisplayCategory\":\"HeartStone\",\"DisplayName\":\"同心石\",\"DisplayDesc\":\"与玉树神像互动，消耗同心石即可进行祈福，祈福会获得石材，天赋玉，妖灵蛋等物品。提升妖灵的好感度会获得同心石。\",\"ObjectId\":\"HeartStone\"},{\"DisplayCategory\":\"REIKI\",\"DisplayName\":\"灵气\",\"DisplayDesc\":\"战斗结束后，出战妖精损失的生命将通过御妖师的灵气进行补充。灵龛和野外神像都可恢复灵气。灵气上限随御妖师等阶提升而上升。\",\"ObjectId\":\"REIKI\"},{\"DisplayCategory\":\"GEM\",\"DisplayName\":\"灵石\",\"DisplayDesc\":\"灵石由特殊的矿石加工而成，比金币更加稀有，具有特殊的力量，可在修行台吸收，也可在特殊商店处交易物品。\",\"ObjectId\":\"GEM\"},{\"DisplayCategory\":\"COIN\",\"DisplayName\":\"金币\",\"DisplayDesc\":\"金币由特殊的矿石加工而成，作为通用的货币，可在所有商人处购买物品。\",\"ObjectId\":\"COIN\"},{\"DisplayCategory\":\"HeartStone\",\"DisplayName\":\"同心石\",\"DisplayDesc\":\"与玉树神像互动，消耗同心石即可进行祈福，祈福会获得石材，天赋玉，妖灵蛋等物品。提升妖灵的好感度会获得同心石。\",\"ObjectId\":\"HeartStone\"},{\"DisplayCategory\":\"REIKI\",\"DisplayName\":\"灵气\",\"DisplayDesc\":\"战斗结束后，出战妖精损失的生命将通过御妖师的灵气进行补充。灵龛和野外神像都可恢复灵气。灵气上限随御妖师等阶提升而上升。\",\"ObjectId\":\"REIKI\"},{\"DisplayCategory\":\"GEM\",\"DisplayName\":\"灵石\",\"DisplayDesc\":\"灵石由特殊的矿石加工而成，比金币更加稀有，具有特殊的力量，可在修行台吸收，也可在特殊商店处交易物品。\",\"ObjectId\":\"GEM\"},{\"DisplayCategory\":\"COIN\",\"DisplayName\":\"金币\",\"DisplayDesc\":\"金币由特殊的矿石加工而成，作为通用的货币，可在所有商人处购买物品。\",\"ObjectId\":\"COIN\"},{\"DisplayCategory\":\"HeartStone\",\"DisplayName\":\"同心石\",\"DisplayDesc\":\"与玉树神像互动，消耗同心石即可进行祈福，祈福会获得石材，天赋玉，妖灵蛋等物品。提升妖灵的好感度会获得同心石。\",\"ObjectId\":\"HeartStone\"},{\"DisplayCategory\":\"REIKI\",\"DisplayName\":\"灵气\",\"DisplayDesc\":\"战斗结束后，出战妖精损失的生命将通过御妖师的灵气进行补充。灵龛和野外神像都可恢复灵气。灵气上限随御妖师等阶提升而上升。\",\"ObjectId\":\"REIKI\"},{\"DisplayCategory\":\"GEM\",\"DisplayName\":\"灵石\",\"DisplayDesc\":\"灵石由特殊的矿石加工而成，比金币更加稀有，具有特殊的力量，可在修行台吸收，也可在特殊商店处交易物品。\",\"ObjectId\":\"GEM\"},{\"DisplayCategory\":\"COIN\",\"DisplayName\":\"金币\",\"DisplayDesc\":\"金币由特殊的矿石加工而成，作为通用的货币，可在所有商人处购买物品。\",\"ObjectId\":\"COIN\"},{\"DisplayCategory\":\"HeartStone\",\"DisplayName\":\"同心石\",\"DisplayDesc\":\"与玉树神像互动，消耗同心石即可进行祈福，祈福会获得石材，天赋玉，妖灵蛋等物品。提升妖灵的好感度会获得同心石。\",\"ObjectId\":\"HeartStone\"},{\"DisplayCategory\":\"REIKI\",\"DisplayName\":\"灵气\",\"DisplayDesc\":\"战斗结束后，出战妖精损失的生命将通过御妖师的灵气进行补充。灵龛和野外神像都可恢复灵气。灵气上限随御妖师等阶提升而上升。\",\"ObjectId\":\"REIKI\"},{\"DisplayCategory\":\"GEM\",\"DisplayName\":\"灵石\",\"DisplayDesc\":\"灵石由特殊的矿石加工而成，比金币更加稀有，具有特殊的力量，可在修行台吸收，也可在特殊商店处交易物品。\",\"ObjectId\":\"GEM\"},{\"DisplayCategory\":\"COIN\",\"DisplayName\":\"金币\",\"DisplayDesc\":\"金币由特殊的矿石加工而成，作为通用的货币，可在所有商人处购买物品。\",\"ObjectId\":\"COIN\"},{\"DisplayCategory\":\"HeartStone\",\"DisplayName\":\"同心石\",\"DisplayDesc\":\"与玉树神像互动，消耗同心石即可进行祈福，祈福会获得石材，天赋玉，妖灵蛋等物品。提升妖灵的好感度会获得同心石。\",\"ObjectId\":\"HeartStone\"},{\"DisplayCategory\":\"REIKI\",\"DisplayName\":\"灵气\",\"DisplayDesc\":\"战斗结束后，出战妖精损失的生命将通过御妖师的灵气进行补充。灵龛和野外神像都可恢复灵气。灵气上限随御妖师等阶提升而上升。\",\"ObjectId\":\"REIKI\"},{\"DisplayCategory\":\"GEM\",\"DisplayName\":\"灵石\",\"DisplayDesc\":\"灵石由特殊的矿石加工而成，比金币更加稀有，具有特殊的力量，可在修行台吸收，也可在特殊商店处交易物品。\",\"ObjectId\":\"GEM\"},{\"DisplayCategory\":\"COIN\",\"DisplayName\":\"金币\",\"DisplayDesc\":\"金币由特殊的矿石加工而成，作为通用的货币，可在所有商人处购买物品。\",\"ObjectId\":\"COIN\"},{\"DisplayCategory\":\"HeartStone\",\"DisplayName\":\"同心石\",\"DisplayDesc\":\"与玉树神像互动，消耗同心石即可进行祈福，祈福会获得石材，天赋玉，妖灵蛋等物品。提升妖灵的好感度会获得同心石。\",\"ObjectId\":\"HeartStone\"},{\"DisplayCategory\":\"REIKI\",\"DisplayName\":\"灵气\",\"DisplayDesc\":\"战斗结束后，出战妖精损失的生命将通过御妖师的灵气进行补充。灵龛和野外神像都可恢复灵气。灵气上限随御妖师等阶提升而上升。\",\"ObjectId\":\"REIKI\"},{\"DisplayCategory\":\"GEM\",\"DisplayName\":\"灵石\",\"DisplayDesc\":\"灵石由特殊的矿石加工而成，比金币更加稀有，具有特殊的力量，可在修行台吸收，也可在特殊商店处交易物品。\",\"ObjectId\":\"GEM\"},{\"DisplayCategory\":\"COIN\",\"DisplayName\":\"金币\",\"DisplayDesc\":\"金币由特殊的矿石加工而成，作为通用的货币，可在所有商人处购买物品。\",\"ObjectId\":\"COIN\"},{\"DisplayCategory\":\"HeartStone\",\"DisplayName\":\"同心石\",\"DisplayDesc\":\"与玉树神像互动，消耗同心石即可进行祈福，祈福会获得石材，天赋玉，妖灵蛋等物品。提升妖灵的好感度会获得同心石。\",\"ObjectId\":\"HeartStone\"},{\"DisplayCategory\":\"REIKI\",\"DisplayName\":\"灵气\",\"DisplayDesc\":\"战斗结束后，出战妖精损失的生命将通过御妖师的灵气进行补充。灵龛和野外神像都可恢复灵气。灵气上限随御妖师等阶提升而上升。\",\"ObjectId\":\"REIKI\"}]";
        customView.setDatasource( (new Gson().fromJson(json,typeToken.getType() )));
    }
}
