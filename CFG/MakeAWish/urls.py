from django.conf.urls import url, include
from MakeAWish import views

urlpatterns = [
    url(r'^admin-panel/$', views.admin_panel, name='admin_panel'),
    url(r'^doctor-panel/$', views.doctor_panel, name='doctor_panel'),
    url(r'^volunteer-panel/$', views.volunteer_panel, name='volunteer_panel'),
    url(r'^donor-panel/$', views.donoe_panel, name='donor_panel'),
    url(r'^wishes-panel/$', views.wishes_panel, name='wishes_panel'),
]
