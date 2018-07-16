package bean;

import java.util.List;

public class Record {
    /**
     * message : null
     * data : [{"stealUserId":"LafOJqmBYnD6WQxuuLr002389","stealNick":"X'Rose🎸","symbol":"LUCIA","amount":0.00371,"stealDate":1531634698000},{"stealUserId":"LafOJqmBYnD6WQxuuLr002389","stealNick":"X'Rose🎸","symbol":"BDB","amount":0.01189,"stealDate":1531634698000},{"stealUserId":"YFUGEoV4d8UsfN0bhsF003671","stealNick":"战小贱","symbol":"LUCIA","amount":0.00292,"stealDate":1531625611000},{"stealUserId":"jaxRysnUrE4zuT0MV0R001919","stealNick":"thirty nine","symbol":"LUCIA","amount":0.00973,"stealDate":1531622483000},{"stealUserId":"7wGjRLXjE6iIcIZXr1u001423","stealNick":"凄美星空","symbol":"LUCIA","amount":0.0027,"stealDate":1531621974000},{"stealUserId":"WPmZzmje9AyuXSsalAq0271367219","stealNick":"futureMan","symbol":"LUCIA","amount":0.003,"stealDate":1531617855000},{"stealUserId":"CByGKk7nklPwg428bnm006827","stealNick":"kakaxjr","symbol":"LUCIA","amount":0.00334,"stealDate":1531615090000},{"stealUserId":"XdkQ2Mr7uFPzkNTt64p069115409","stealNick":"cr7","symbol":"LUCIA","amount":0.00371,"stealDate":1531612979000},{"stealUserId":"cdQYOEnxGrHg1zsDptN009798","stealNick":"*永潇","symbol":"GXS","amount":1.1E-4,"stealDate":1531570545000},{"stealUserId":"cdQYOEnxGrHg1zsDptN009798","stealNick":"*永潇","symbol":"BCDN","amount":0.00169,"stealDate":1531570544000},{"stealUserId":"cdQYOEnxGrHg1zsDptN009798","stealNick":"*永潇","symbol":"LVCOIN","amount":0.00186,"stealDate":1531570544000},{"stealUserId":"amv3XZ2xHEFoRaHG4t0005646","stealNick":"风小玲","symbol":"BCDN","amount":0.00188,"stealDate":1531569795000},{"stealUserId":"amv3XZ2xHEFoRaHG4t0005646","stealNick":"风小玲","symbol":"PPS","amount":8.0E-4,"stealDate":1531569795000},{"stealUserId":"amv3XZ2xHEFoRaHG4t0005646","stealNick":"风小玲","symbol":"LVCOIN","amount":0.00207,"stealDate":1531569795000},{"stealUserId":"amv3XZ2xHEFoRaHG4t0005646","stealNick":"风小玲","symbol":"GXS","amount":2.7E-4,"stealDate":1531569795000},{"stealUserId":"CxMdQnpelr7oA0nH2Ag005029","stealNick":"懒张","symbol":"PPS","amount":8.8E-4,"stealDate":1531568406000},{"stealUserId":"CxMdQnpelr7oA0nH2Ag005029","stealNick":"懒张","symbol":"BCDN","amount":0.00209,"stealDate":1531568405000},{"stealUserId":"CxMdQnpelr7oA0nH2Ag005029","stealNick":"懒张","symbol":"GXS","amount":1.5E-4,"stealDate":1531568405000},{"stealUserId":"CxMdQnpelr7oA0nH2Ag005029","stealNick":"懒张","symbol":"LVCOIN","amount":0.0023,"stealDate":1531568405000},{"stealUserId":"GVmpDsYSf3Eim2EIFOp003310","stealNick":"文礼永存","symbol":"BCDN","amount":0.00232,"stealDate":1531568313000},{"stealUserId":"GVmpDsYSf3Eim2EIFOp003310","stealNick":"文礼永存","symbol":"GXS","amount":1.7E-4,"stealDate":1531568313000},{"stealUserId":"GVmpDsYSf3Eim2EIFOp003310","stealNick":"文礼永存","symbol":"LVCOIN","amount":0.00255,"stealDate":1531568313000},{"stealUserId":"GVmpDsYSf3Eim2EIFOp003310","stealNick":"文礼永存","symbol":"PPS","amount":9.8E-4,"stealDate":1531568312000},{"stealUserId":"FTvMdSLyCww20v5hSSo009267","stealNick":"凯&盛","symbol":"BCDN","amount":0.00258,"stealDate":1531567353000},{"stealUserId":"FTvMdSLyCww20v5hSSo009267","stealNick":"凯&盛","symbol":"PPS","amount":0.00109,"stealDate":1531567353000},{"stealUserId":"FTvMdSLyCww20v5hSSo009267","stealNick":"凯&盛","symbol":"GXS","amount":4.2E-4,"stealDate":1531567352000},{"stealUserId":"FTvMdSLyCww20v5hSSo009267","stealNick":"凯&盛","symbol":"LVCOIN","amount":0.00283,"stealDate":1531567351000},{"stealUserId":"iWFdhtxfTWfmZ0fdmxW001880","stealNick":"度坡四","symbol":"GXS","amount":2.3E-4,"stealDate":1531566956000},{"stealUserId":"iWFdhtxfTWfmZ0fdmxW001880","stealNick":"度坡四","symbol":"PPS","amount":0.00121,"stealDate":1531566955000},{"stealUserId":"iWFdhtxfTWfmZ0fdmxW001880","stealNick":"度坡四","symbol":"BCDN","amount":0.00287,"stealDate":1531566955000}]
     */

    private Object message;
    private List<DataBean> data;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * stealUserId : LafOJqmBYnD6WQxuuLr002389
         * stealNick : X'Rose🎸
         * symbol : LUCIA
         * amount : 0.00371
         * stealDate : 1531634698000
         */

        private String stealUserId;
        private String stealNick;
        private String symbol;
        private double amount;
        private long stealDate;

        public String getStealUserId() {
            return stealUserId;
        }

        public void setStealUserId(String stealUserId) {
            this.stealUserId = stealUserId;
        }

        public String getStealNick() {
            return stealNick;
        }

        public void setStealNick(String stealNick) {
            this.stealNick = stealNick;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public long getStealDate() {
            return stealDate;
        }

        public void setStealDate(long stealDate) {
            this.stealDate = stealDate;
        }
    }
}
