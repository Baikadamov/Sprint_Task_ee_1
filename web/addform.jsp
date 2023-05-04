<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/addItem" method="post">
    <div class="modal-body">
        <div class="container">
            <div class="row">
                <div class="col-8 mx-auto">
                    <div class="mt-3">
                        <label> Name</label>
                        <input type="text" name="item_name" class="form-control" placeholder="name">
                    </div>
                    <div class="mt-3">
                        <label> Description</label>
                        <textarea name="item_description" class="form-control"
                        ></textarea>
                    </div>
                    <div class="mt-3">
                        <label> Price</label>
                        <input type="number" name="item_price" class="form-control"  >
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-success">Add</button>
    </div>
</form>