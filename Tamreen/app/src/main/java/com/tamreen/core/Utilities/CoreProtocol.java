package com.tamreen.core.Utilities;

import android.util.Log;


public class CoreProtocol {

    public interface CorDelegate<T> {
        void PassObject(T a);

        void PassObject(T a, T b);

    }

    public interface ResultDelegate<T> {
        void OnSuccess(Boolean status);

        void OnSuccess(Boolean status, T a);

        void OnSuccess(Boolean status, T a, T b);

        void OnSuccess(Boolean status, T a, T b, T c);
    }

    public interface CartChangeDelegate<T> {
        void updateQTY(int position, int qty);

        void deleteItem(int position);

        void addCardMessage(int position);

        void deleteCardMessage(int position);
    }

    public interface DeleteDelegate<T> {
        void DeleteItem(int position);
        void Edit(int position);
    }
    public interface PassText<T>{
        void OnPassText(String text);
    }
    public interface LoginFinshed<T>{
        void OnLoginFInished();
    }


    public interface OnCustomStateListener {
        void stateChanged();

        void scanned(String code);
    }
    public interface PassFilter<T>{
        void OnPassFilter(T filter);
    }

     public interface PassId<T>{
        void OnPassId(int id);
    }

    public interface PassFilterObj<T>{
        void OnPassFilterObj(T filter);
    }
    public interface PassCartMessage<T>{
        void OnPassCartMessage(String from, String to, String msg, int cartId);
    }
    public interface PassNoteString<T>{
        void OnPassNotes(String from);
    }

    public interface PassMessageString<T>{
        void OnPassMessage(String from);
    }
    public interface PassFile<T>{
        void OnPassFile(String filePath);
    }
    public interface PassCheckoutToken<T>{
        void onPassToken(String from, boolean savedCardStatus);
    }
    public interface CustomListner<T>{
        void onFinished();
    }

    public interface PassOrder<T>{
        void OnPassOrder(T order);
    }
    private static CoreProtocol mInstance;
    private OnCustomStateListener mListener;
    private CorDelegate coreListener;
    private ResultDelegate resultDelegate;

    private DeleteDelegate deleteDelegate;
    private PassId passId;
    private PassFilter passFilter;
    private PassOrder passOrder;
    private PassFilterObj passFilterObj;
    private PassCartMessage passCartMessage;
    private PassNoteString passNoteString;
    private PassMessageString passMessageString;
    private PassFile passFile;
    private PassCheckoutToken passCheckoutToken;
    private CustomListner customListner;
    private PassText passText;
    private LoginFinshed loginFinshed;

    public LoginFinshed getLoginFinshed() {
        return loginFinshed;
    }

    public void setLoginFinshed(LoginFinshed loginFinshed) {
        this.loginFinshed = loginFinshed;
    }

    public PassText getPassText() {
        return passText;
    }

    public void setPassText(PassText passText) {
        this.passText = passText;
    }

    public PassId getPassId() {
        return passId;
    }

    public void setPassId(PassId passId) {
        this.passId = passId;
    }



    public CustomListner getCustomListner() {
        return customListner;
    }

    public void setCustomListner(CustomListner customListner) {
        this.customListner = customListner;
    }

    public PassCheckoutToken getPassCheckoutToken() {
        return passCheckoutToken;
    }

    public void setPassCheckoutToken(PassCheckoutToken passCheckoutToken) {
        this.passCheckoutToken = passCheckoutToken;
    }

    public PassFile getPassFile() {
        return passFile;
    }

    public void setPassFile(PassFile passFile) {
        this.passFile = passFile;
    }

    public PassMessageString getPassMessageString() {
        return passMessageString;
    }

    public void setPassMessageString(PassMessageString passMessageString) {
        this.passMessageString = passMessageString;
    }

    public PassNoteString getPassNoteString() {
        return passNoteString;
    }

    public void setPassNoteString(PassNoteString passNoteString) {
        this.passNoteString = passNoteString;
    }

    public PassCartMessage getPassCartMessage() {
        return passCartMessage;
    }

    public void setPassCartMessage(PassCartMessage passCartMessage) {
        this.passCartMessage = passCartMessage;
    }

    public PassFilterObj getPassFilterObj() {
        return passFilterObj;
    }

    public void setPassFilterObj(PassFilterObj passFilterObj) {
        this.passFilterObj = passFilterObj;
    }

    public PassOrder getPassOrder() {
        return passOrder;
    }

    public void setPassOrder(PassOrder passOrder) {
        this.passOrder = passOrder;
    }

    public PassFilter getPassFilter() {
        return passFilter;
    }

    public void setPassFilter(PassFilter passFilter) {
        this.passFilter = passFilter;
    }

    public ResultDelegate getResultDelegate() {
        return resultDelegate;
    }

    public void setResultDelegate(ResultDelegate resultDelegate) {
        this.resultDelegate = resultDelegate;
    }

    public DeleteDelegate getDeleteDelegate() {
        return deleteDelegate;
    }

    public void setDeleteDelegate(DeleteDelegate deleteDelegate) {
        this.deleteDelegate = deleteDelegate;
    }

    private CartChangeDelegate cartChangeDelegate;
    private boolean mState;

    private CoreProtocol() {
    }

    public static CoreProtocol getInstance() {
        if (mInstance == null) {
            mInstance = new CoreProtocol();
        }
        return mInstance;
    }

    public void setListener(OnCustomStateListener listener) {
        mListener = listener;
    }

    public void setCoreListener(CorDelegate listener) {
        coreListener = listener;
    }

    public void setCartChangeDelegate(CartChangeDelegate cartChangeDelegate) {
        this.cartChangeDelegate = cartChangeDelegate;
    }

    public void updateQTY(int position, int qty) {
        if (cartChangeDelegate != null) {
            cartChangeDelegate.updateQTY(position, qty);

        } else {
            print("cartChangeDelegate is null");
        }
    }

    public void OnPassText(String text) {
        if (passText != null) {
            passText.OnPassText(text);

        } else {
            print("passText is null");
        }
    }
    public void OnLoginFInished() {
        if (loginFinshed != null) {
            loginFinshed.OnLoginFInished();

        } else {
            print("passText is null");
        }
    }
    public void deleteItem(int position) {
        if (cartChangeDelegate != null) {
            cartChangeDelegate.deleteItem(position);

        } else {
            print("cartChangeDelegate is null");
        }
    }
    public void passId(int id){
        if(passId != null){
            passId.OnPassId(id);
        }
    }
    public void passFilter(Object filter) {
        if (passFilter != null) {
            passFilter.OnPassFilter(filter);

        } else {
            print("passFilter is null");
        }
    }
    public void passFilterObj(Object filter) {
        if (passFilterObj != null) {
            passFilterObj.OnPassFilterObj(filter);

        } else {
            print("passFilter is null");
        }
    }

    public void onPassCartMessage(String from,String to,String msg,int cartId) {
        if (passCartMessage != null) {
            passCartMessage.OnPassCartMessage(from,to,msg,cartId);

        } else {
            print("passCartMessage is null");
        }
    }
    public void onFinished(){
        if(customListner != null){
            customListner.onFinished();
        }
        else {
            print("CustomListner is null");
        }
    }
    public void OnPassFile(String filePath){
        if(passFile != null){
            passFile.OnPassFile(filePath);
        }
        else {
            print("passNoteString is null");
        }
    }
    public void OnPassMessage(String from) {
        if (passMessageString != null) {
            passMessageString.OnPassMessage(from);

        } else {
            print("passNoteString is null");
        }
    }
    public void OnPassNotes(String from) {
        if (passNoteString != null) {
            passNoteString.OnPassNotes(from);

        } else {
            print("passNoteString is null");
        }
    }
    public void onPassToken(String from,boolean savedCardStatus) {
        if (passCheckoutToken != null) {
            passCheckoutToken.onPassToken(from,savedCardStatus);

        } else {
            print("passCheckoutToken is null");
        }
    }
    public void passOrder(Object order) {
        if (passOrder != null) {
            passOrder.OnPassOrder(order);

        } else {
            print("passOrder is null");
        }
    }


    public void delete(int position) {
        if (deleteDelegate != null) {
            deleteDelegate.DeleteItem(position);
        } else {
            print("deleteDelegate is null");
        }
    }

    public void edit(int position) {
        if (deleteDelegate != null) {
            deleteDelegate.Edit(position);
        } else {
            print("deleteDelegate is null");
        }
    }

    public void addCardMessage(int position) {
        if (cartChangeDelegate != null) {
            cartChangeDelegate.addCardMessage(position);
        } else {
            print("cartChangeDelegate is null");
        }
    }


    public void deleteCardMessage(int position) {
        if (cartChangeDelegate != null) {
            cartChangeDelegate.deleteCardMessage(position);
        } else {
            print("cartChangeDelegate is null");
        }
    }


    private void print(String msg) {
        Log.d("**CoreDelegate", msg);
    }


    public void changeState(boolean state) {
        if (mListener != null) {
            mState = state;
            notifyStateChange();
        } else {
            print("MListener is null");
        }
    }

    public void PassObject(Object a) {
        if (coreListener != null) {
            coreListener.PassObject(a);
        } else {
            print("Core Listener is null");
        }

    }

    public void PassObject(Object a, Object b) {
        if (coreListener != null) {
            coreListener.PassObject(a, b);
        } else {
            print("Core Listener is null");
        }

    }


    public void OnSuccess(Boolean status) {
        if (resultDelegate != null) {
            resultDelegate.OnSuccess(status);
        } else {
            print("resultDelegate is null");
        }
    }

    public void OnSuccess(Boolean status, Object a) {
        if (resultDelegate != null) {
            resultDelegate.OnSuccess(status, a);
        } else {
            print("resultDelegate is null");
        }
    }

    public void OnSuccess(Boolean status, Object a, Object b) {
        if (resultDelegate != null) {
            resultDelegate.OnSuccess(status, a, b);
        } else {
            print("resultDelegate is null");
        }
    }

    public void OnSuccess(Boolean status, Object a, Object b, Object c) {
        if (resultDelegate != null) {
            resultDelegate.OnSuccess(status, a, b, c);
        } else {
            print("resultDelegate is null");
        }
    }


    public void scanned(String code) {
        if (mListener != null) {
            notifyScanned(code);
        }
    }

    public boolean getState() {
        return mState;
    }

    private void notifyStateChange() {
        mListener.stateChanged();
    }

    private void notifyScanned(String code) {
        mListener.scanned(code);

    }
}
