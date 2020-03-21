package classUML;
/**
 * @startuml
 *
 * title ログイン(成功時)
 *
 * object セッションスコープ{
 * }
 *
 * class model.LoginPost <<Entitiy>> {
 *-userId :String
 *-pass :String
 * }
 *
 * class model.User <<Entitiy>>{
 * -userId :String
 * -pass :String
 * -mail :String
 * -name :String
 * -userName :String
 * -createdAt :DateTime
 * }
 *
 * class model.LoginLogic<<BO>>{
 * +execute(loginPost : LoginPost) : boolean
 * }
 *
 * class model.UserDAO <<DAO>>{
 * +findByLogin(loginPost : LoginPost) : User
 * }
 *
 * class controller.LoginServlet{
 * doPost()
 * }
 *
 * class view.welcome_jsp{
 *
 * }
 * class view.main_jsp{
 *
 * }
 *
 * object userテーブル{
 *
 * }
 *
 *controller.LoginServlet -> セッションスコープ:userIdを保存
 * セッションスコープ <-down- view.main_jsp :userIdを取得
 *
 * view.welcome_jsp <-- controller.LoginServlet :リクエストパラメータ取得\nPOST(userId,pass)
 * controller.LoginServlet --> view.main_jsp:フォワード
 *
 * controller.LoginServlet --> model.LoginPost
 * model.LoginLogic --> model.LoginPost
 * model.UserDAO --> model.LoginPost
 * model.LoginLogic --> model.User
 * model.UserDAO --> model.User
 *
 * controller.LoginServlet --> model.LoginLogic:ログイン実行\nexecute(loginPost)
 * model.LoginLogic --> model.UserDAO:該当ユーザー検索\nfindByLogin(loginPost)
 * model.UserDAO --> userテーブル:SELECT\nuser_id,pass
 *
 *
 * @enduml
 *
 */
public class Login {

}
