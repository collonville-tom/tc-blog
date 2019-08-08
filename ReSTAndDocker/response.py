

def str_http_response(response):
    print("STATUS:" + str(response.status_code))
    print("HEADERS:" + str(response.headers))
    print("BODY:" + str(response.body))
