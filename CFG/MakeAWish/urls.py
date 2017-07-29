from django.conf.urls import url, include
from MakeAWish import views

urlpatterns = [
    url(r'^admin-panel/$', views.admin_panel, name = 'admin_panel'),
]
