package bean;

import java.util.List;

public class MyFortuneList {
    /**
     * message : null
     * data : {"mines":[{"id":404289917,"status":1,"validTime":1531376400000,"symbol":"BDB","amount":0.11924},{"id":403710055,"status":1,"validTime":1531376700000,"symbol":"BCDN","amount":0.0569},{"id":399099192,"status":1,"validTime":1531378980000,"symbol":"LUCIA","amount":0.00663},{"id":406063671,"status":1,"validTime":1531385700000,"symbol":"LVCOIN","amount":0.11684},{"id":399098213,"status":1,"validTime":1531386840000,"symbol":"BCDN","amount":0.01118},{"id":397683551,"status":1,"validTime":1531389300000,"symbol":"GXS","amount":9.1E-4},{"id":406428394,"status":1,"validTime":1531395300000,"symbol":"PPS","amount":0.03863},{"id":402842087,"status":1,"validTime":1531396860000,"symbol":"LVCOIN","amount":0.0326},{"id":403320918,"status":1,"validTime":1531406160000,"symbol":"PPS","amount":0.02281},{"id":396999630,"status":1,"validTime":1531406340000,"symbol":"LUCIA","amount":0.0195}]}
     */

    private Object message;
    private DataBean data;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<MinesBean> mines;

        public List<MinesBean> getMines() {
            return mines;
        }

        public void setMines(List<MinesBean> mines) {
            this.mines = mines;
        }

        public static class MinesBean {
            /**
             * id : 404289917
             * status : 1
             * validTime : 1531376400000
             * symbol : BDB
             * amount : 0.11924
             */

            private int id;
            private int status;
            private long validTime;
            private String symbol;
            private double amount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public long getValidTime() {
                return validTime;
            }

            public void setValidTime(long validTime) {
                this.validTime = validTime;
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
        }
    }
}
