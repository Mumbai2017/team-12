from django.http import HttpResponse
from django.shortcuts import render
from MakeAWish.models import ChildProfile, Doctor, Volunteer, Donor, Transaction
from CFG.settings import TEMPLATE_PATH, STATIC_URL


# VIews for Admin Dashboard
def start_page(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/index.html')


def admin_panel(request):
    pending_wishes = ChildProfile.objects.filter(wish_status__lte=3).count()
    pending_approval = Volunteer.objects.filter(status=False).count()
    doc_list = Doctor.objects.all().count()
    active_donors = Donor.objects.all().count()
    context_dict = {'active_donors': active_donors, 'doc_list': doc_list, 'pending_wishes': pending_wishes,
                    'pending_approval': pending_approval}
    return render(request, TEMPLATE_PATH + '/MakeAWish/index-admin.html', context_dict)


def wishes_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/wishes.html')


def volunteer_panel(request):
    pending_approval = Volunteer.objects.filter(status=False).count()
    context_dict = {'pending': pending_approval}
    return render(request, TEMPLATE_PATH + '/MakeAWish/vol.html', context_dict)


def doctor_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/doc.html')


def donoe_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/donor.html')


# View for the Staff Dashboard
def staff_panel(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/staff/staff.html')


def login(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/login.html')


def staff_full(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/staff/full.html')


def staff_mail(request):
    return render(request, TEMPLATE_PATH + '/MakeAWish/staff/mail.html')
